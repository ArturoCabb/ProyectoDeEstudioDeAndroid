package com.example.proyectodetarjetasparaaaprenderandroid.data

import com.example.proyectodetarjetasparaaaprenderandroid.network.MarsApiService
import com.example.proyectodetarjetasparaaaprenderandroid.network.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(private val  marsApiservice: MarsApiService) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiservice.getPhotos()
}