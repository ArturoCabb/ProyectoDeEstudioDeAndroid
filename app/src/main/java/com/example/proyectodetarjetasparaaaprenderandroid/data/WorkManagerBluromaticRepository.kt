package com.example.proyectodetarjetasparaaaprenderandroid.data

import android.content.Context
import android.net.Uri
import androidx.lifecycle.asFlow
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.proyectodetarjetasparaaaprenderandroid.IMAGE_MANIPULATION_WORK_NAME
import com.example.proyectodetarjetasparaaaprenderandroid.KEY_BLUR_LEVEL
import com.example.proyectodetarjetasparaaaprenderandroid.KEY_IMAGE_URI
import com.example.proyectodetarjetasparaaaprenderandroid.TAG_OUTPUT
import com.example.proyectodetarjetasparaaaprenderandroid.getImageUri
import com.example.proyectodetarjetasparaaaprenderandroid.workers.BlurWorker
import com.example.proyectodetarjetasparaaaprenderandroid.workers.CleanupWorker
import com.example.proyectodetarjetasparaaaprenderandroid.workers.SaveImageToFileWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull

class WorkManagerBluromaticRepository(context: Context) : BluromaticRepository {

    private val workManager = WorkManager.getInstance(context)

    private val imageUri: Uri = context.getImageUri()

    override val outputWorkInfo: Flow<WorkInfo> =
        workManager.getWorkInfosByTagLiveData(TAG_OUTPUT).asFlow().mapNotNull {
            if (it.isNotEmpty()) it.first() else null
        }

    /**
     * Create the WorkRequests to apply the blur and save the resulting image
     * @param blurLevel The amount to blur the image
     */
    override fun applyBlur(blurLevel: Int) {
        /*var continuation = workManager.beginWith(
            OneTimeWorkRequest.from(CleanupWorker::class.java)
            // Tambien se puede uasr OneTimeWorkRequestBuilder<CleanupWorker>().build()
        )*/
        var continuation = workManager.beginUniqueWork(
            IMAGE_MANIPULATION_WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            OneTimeWorkRequest.from(CleanupWorker::class.java)
        )
        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
            .build()
        val blurBuilder = OneTimeWorkRequestBuilder<BlurWorker>()
        blurBuilder.setInputData(createInputDataForWorkRequest(blurLevel, imageUri))
        blurBuilder.setConstraints(constraints)
        //workManager.enqueue(blurBuilder.build())
        continuation = continuation.then(blurBuilder.build())
        // Add WorkRequest to save the image to the filesystem
        val save = OneTimeWorkRequestBuilder<SaveImageToFileWorker>().addTag(TAG_OUTPUT).build()
        continuation = continuation.then(save)
        continuation.enqueue()
    }

    /**
     * Cancel any ongoing WorkRequests
     * */
    override fun cancelWork() {
        workManager.cancelUniqueWork(IMAGE_MANIPULATION_WORK_NAME)
    }

    /**
     * Creates the input data bundle which includes the blur level to
     * update the amount of blur to be applied and the Uri to operate on
     * @return Data which contains the Image Uri as a String and blur level as an Integer
     */
    private fun createInputDataForWorkRequest(blurLevel: Int, imageUri: Uri): Data {
        val builder = Data.Builder()
        builder.putString(KEY_IMAGE_URI, imageUri.toString()).putInt(KEY_BLUR_LEVEL, blurLevel)
        return builder.build()
    }
}