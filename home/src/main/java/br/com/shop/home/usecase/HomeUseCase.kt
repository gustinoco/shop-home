package br.com.shop.home.usecase

import br.com.shop.home.HomeCallback

class HomeUseCase(private val callback: HomeCallback?) {

    fun loadCart(): Boolean? {
        return callback?.hasCacheCart()
    }
}