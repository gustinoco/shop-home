package br.com.shop.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.shop.home.HomeModuleSession

class ShopViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        HomeViewModel(HomeModuleSession.homeCallback, HomeModuleSession.dependencies.shopAnalytics) as T
}
