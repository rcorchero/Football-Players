package com.rcorchero.footballplayers.presentation.views

interface BaseView {

    fun showLoading()
    fun hideLoading()

    fun showConnectionError()
    fun showDefaultError()
    fun showError(errorDescription: String)
}