package br.com.shop.home.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.shop.commons.ShopRoutes
import br.com.shop.home.HomeModuleSession
import br.com.shop.home.databinding.HomeActivityBinding
import br.com.shop.home.viewmodel.HomeViewModel
import br.com.shop.home.viewmodel.HomeViewState
import br.com.shop.home.viewmodel.ShopViewModelFactory

internal class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding

    private val viewModel by lazy {
        ViewModelProvider(this, ShopViewModelFactory())[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(ShoploginSession.theme)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        initObservers()
    }

    fun initObservers() {
        viewModel.viewState.observe(this) {
            when (it) {
                is HomeViewState.SucessCartPending -> binding.linearCarrinho.visibility = View.VISIBLE

                is HomeViewState.GoneCartPending -> binding.linearCarrinho.visibility = View.GONE

            }
        }
    }

    fun init() {
        viewModel.init()

        binding.btnIrCarrinho.setOnClickListener {
            HomeModuleSession.dependencies.shopNavigate?.navigate(
                this,
                ShopRoutes.Cart.route
            )
        }
        binding.btnComprarProdutos.setOnClickListener {
            HomeModuleSession.dependencies.shopNavigate?.navigate(this, ShopRoutes.Shopping.route)
        }
    }
}