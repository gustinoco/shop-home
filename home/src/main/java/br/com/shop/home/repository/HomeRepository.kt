package br.com.shop.home.repository

import br.com.shop.commons.ShopNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository(val api: ShopNetwork?) {

    suspend fun postLogin(
        loginRequest: HomeRequest
    ): HomeResponse {
        val response = withContext(Dispatchers.Default) {
            api?.postNetwork("", Any(), loginRequest) as HomeResponse
        }
        return response
    }
}