package br.com.shop.home.repository

import com.google.gson.annotations.SerializedName

data class HomeRequest(
    @SerializedName("cpf")
    val cpf: String? = null)