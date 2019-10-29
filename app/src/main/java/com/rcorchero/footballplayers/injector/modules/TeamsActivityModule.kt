package com.rcorchero.footballplayers.injector.modules

import com.rcorchero.footballplayers.domain.interactor.GetTeamsInteractor
import com.rcorchero.footballplayers.domain.model.Team
import dagger.Module
import dagger.Provides

@Module
class TeamsActivityModule {

    @Provides
    internal fun providePresenter(getTeamsInteractor: GetTeamsInteractor<List<Team>>): TeamsPresenter
            = TeamsPresenter(getTeamsInteractor)
}