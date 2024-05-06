package br.com.shop.home.viewmodel

sealed class HomeViewState {

    object SucessCartPending : HomeViewState()
    object GoneCartPending : HomeViewState()

}