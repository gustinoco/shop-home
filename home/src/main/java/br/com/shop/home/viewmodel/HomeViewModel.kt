package br.com.shop.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.shop.commons.ShopAnalytics
import br.com.shop.home.AnalyticsConstants
import br.com.shop.home.HomeCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import br.com.shop.home.usecase.HomeUseCase

class HomeViewModel(callback: HomeCallback?, private var shopAnalytics: ShopAnalytics?) : ViewModel() {

    private val state: MutableLiveData<HomeViewState> = MutableLiveData()
    val viewState: LiveData<HomeViewState> = state

    private var homeUseCase: HomeUseCase = HomeUseCase(callback)

    private val viewModelJob = SupervisorJob()
    private val coroutineContext = Dispatchers.Main + viewModelJob

    fun init() {

        CoroutineScope(coroutineContext).launch {

            val response = homeUseCase.loadCart()
            if (response == true) {
                shopAnalytics?.trackScreen(AnalyticsConstants.TrackScreenHome)
                state.value = HomeViewState.SucessCartPending
            } else {
                state.value = HomeViewState.GoneCartPending
            }
        }
    }
}