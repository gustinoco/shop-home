package br.com.shop.home

import android.content.Context
import android.content.Intent
import br.com.shop.home.view.HomeActivity
import kotlin.properties.Delegates

class HomeLoginInitializer private constructor(builder: Builder) {

    init {
        HomeModuleSession.dependencies = builder.homeModuleDependencies
        HomeModuleSession.theme = builder.theme
        HomeModuleSession.homeCallback = builder.homeCallback
        startModuleActivity(builder.context)
    }

    private fun startModuleActivity(context: Context) {
        context.startActivity(
            Intent(context, HomeActivity::class.java)
        )
    }

    class Builder {
        internal var context: Context by Delegates.notNull()
        internal var theme: Int by Delegates.notNull()
        internal var homeCallback: HomeCallback by Delegates.notNull()
        internal var homeModuleDependencies: HomeModuleDependencies by Delegates.notNull()

        fun setContext(context: Context) = apply {
            this.context = context
        }

        fun setHomeCallback(homeCallback: HomeCallback) = apply {
            this.homeCallback = homeCallback
        }

        fun setTheme(theme: Int) = apply {
            this.theme = theme
        }

        fun setLoginModuleDependencies(homeModuleDependencies: HomeModuleDependencies) = apply {
            this.homeModuleDependencies = homeModuleDependencies
        }

        fun build() {
            HomeLoginInitializer(this)
        }
    }
}
