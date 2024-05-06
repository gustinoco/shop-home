package br.com.shop.home.repository

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("message")
    var message: String? = null,
    @SerializedName("message")
    var lastLogin: String = ""
)