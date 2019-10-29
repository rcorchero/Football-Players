package com.rcorchero.footballplayers.platform

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FootballPlayersApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<FootballPlayersApplication> {
        val component = DaggerAppComponent.builder().application(this).build()
        component.inject(this)
        return component
    }
}