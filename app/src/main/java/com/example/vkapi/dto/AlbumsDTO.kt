package com.example.vkapi.dto

import com.example.vkapi.models.Album
import com.google.gson.annotations.SerializedName

data class Albums(
    @SerializedName("count") var count: Int,
    @SerializedName("items") var items: List<Album>,
)

data class AlbumsDTO(
    @SerializedName("response") var response: Albums,
    @SerializedName("error") var error: Int
)