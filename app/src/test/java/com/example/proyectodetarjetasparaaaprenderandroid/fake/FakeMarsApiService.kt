package com.example.proyectodetarjetasparaaaprenderandroid.fake

import com.example.proyectodetarjetasparaaaprenderandroid.network.MarsApiService
import com.example.proyectodetarjetasparaaaprenderandroid.network.MarsPhoto

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> = FakeDataSource.photosList
}