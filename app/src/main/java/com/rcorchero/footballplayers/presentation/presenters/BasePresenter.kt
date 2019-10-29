package com.rcorchero.footballplayers.presentation.presenters

import com.rcorchero.footballplayers.domain.interactor.common.Interactor
import com.rcorchero.footballplayers.domain.model.errors.ApiError
import com.rcorchero.footballplayers.presentation.views.BaseView

abstract class BasePresenter<V : BaseView> {

    protected lateinit var view: V

    fun attachView(view: V) {
        this.view = view
        onViewAttached()
    }

    fun detachView() {
        onViewDetached()
    }

    abstract fun onViewAttached()

    abstract fun onViewDetached()

    fun <T> execute(interactor: Interactor<T>,
                    onSuccess: (T) -> Unit = {},
                    onSuccessIgnoreResponse: () -> Unit = {},
                    noConnection: () -> Unit = this::connectionError,
                    onApiError: (ApiError) -> Unit = this::onApiError,
                    genericError: () -> Unit = this::genericError) {
        interactor.execute(onSuccess, onSuccessIgnoreResponse, noConnection, onApiError, genericError)
    }

    private fun connectionError() {
        view.hideLoading()
        view.showConnectionError()
    }

    private fun onApiError(apiError: ApiError) {
        view.hideLoading()
        view.showError(apiError.message)
    }

    private fun genericError() {
        view.hideLoading()
        view.showDefaultError()
    }
}