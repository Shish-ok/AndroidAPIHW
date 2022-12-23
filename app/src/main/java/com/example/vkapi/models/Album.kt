package com.example.vkapi.models

import com.google.gson.annotations.SerializedName

data class Album (
    @SerializedName("id") var id: Int,
    @SerializedName("owner_id") var ownerID: Int,
    @SerializedName("title") var title: String,
)