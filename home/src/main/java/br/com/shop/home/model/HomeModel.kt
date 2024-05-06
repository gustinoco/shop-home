package br.com.shop.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeModel(
    val cpf: String,
    val lastLogin: String
) : Parcelable