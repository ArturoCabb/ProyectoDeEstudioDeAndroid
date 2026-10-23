package com.example.proyectodetarjetasparaaaprenderandroid.fake

import com.example.proyectodetarjetasparaaaprenderandroid.data.MarsPhotosRepository
import com.example.proyectodetarjetasparaaaprenderandroid.network.MarsPhoto

class FakeNetworkMarsPhotosRepository : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = FakeDataSource.photosList
}