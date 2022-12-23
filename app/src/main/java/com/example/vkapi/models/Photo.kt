package com.example.vkapi.models

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("url") var photoURL: String
)