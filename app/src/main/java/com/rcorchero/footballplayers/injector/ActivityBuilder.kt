package com.rcorchero.footballplayers.injector

import com.rcorchero.footballplayers.injector.modules.TeamsActivityModule
import com.rcorchero.footballplayers.platform.views.TeamsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(TeamsActivityModule::class)])
    @PerActivity
    internal abstract fun bindTeamsActivity(): TeamsActivity
}