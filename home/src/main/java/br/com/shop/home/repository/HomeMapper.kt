package br.com.shop.home.repository

import br.com.shop.home.model.HomeModel

object HomeMapper {

    fun convertResponseToModel(
        response: HomeResponse,
        cpf: String
    ) = HomeModel(
        lastLogin = response.lastLogin,
        cpf = cpf
    )
}
