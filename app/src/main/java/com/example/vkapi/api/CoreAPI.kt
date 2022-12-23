package com.example.vkapi.api

import com.example.vkapi.dto.AlbumsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoreAPI {
    @GET("photos.getAlbums")
    suspend fun getAlbums(
        @Query("owner_id") ownerID: String,
    ): Response<AlbumsDTO>
}