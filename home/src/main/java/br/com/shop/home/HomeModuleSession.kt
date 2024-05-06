package br.com.shop.home

import kotlin.properties.Delegates

object HomeModuleSession {

    var dependencies: HomeModuleDependencies by Delegates.notNull()
    var theme: Int by Delegates.notNull()
    var homeCallback: HomeCallback by Delegates.notNull()

}