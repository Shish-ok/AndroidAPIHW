package com.example.vkapi.dto

import com.example.vkapi.models.Photo
import com.google.gson.annotations.SerializedName

data class PhotosURLs(
    @SerializedName("sizes") var sizes: List<Photo>
)

data class PhotoItems(
    @SerializedName("items") var items: List<PhotosURLs>,
    @SerializedName("count") var count: Int,
)

data class PhotosDTO(
    @SerializedName("response") var response: PhotoItems,
    @SerializedName("error") var error: Int,
)