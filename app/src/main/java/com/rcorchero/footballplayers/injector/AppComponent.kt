package com.rcorchero.footballplayers.injector

import android.app.Application
import com.rcorchero.footballplayers.injector.modules.AppModule
import com.rcorchero.footballplayers.platform.FootballPlayersApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class])
interface AppComponent : AndroidInjector<FootballPlayersApplication> {

    override fun inject(app: FootballPlayersApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}