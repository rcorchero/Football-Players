package com.rcorchero.footballplayers.domain.interactor.common

import com.rcorchero.footballplayers.data.exception.ServiceException
import com.rcorchero.footballplayers.domain.model.errors.ApiError
import com.rcorchero.footballplayers.domain.model.errors.GenericError
import com.rcorchero.footballplayers.domain.model.errors.NoConnectionError
import kotlinx.coroutines.*
import java.net.UnknownHostException

abstract class Interactor<T> {

    @Throws(Exception::class)
    abstract suspend fun execution(): Any

    private var result: Deferred<*>? = null

    fun execute(
        onSuccess: (T) -> Unit,
        onSuccessIgnoreResponse: () -> Unit,
        noConnection: () -> Unit,
        onApiError: (ApiError) -> Unit,
        genericError: () -> Unit
    ) {
        result = GlobalScope.async {
            try {
                execution()
            } catch (e: UnknownHostException) {
                NoConnectionError()
            } catch (e: ServiceException) {
                ApiError(e.message ?: "")
            } catch (e: Exception) {
                GenericError()
            }
        }
        GlobalScope.launch(Dispatchers.Main) {
            result?.await()?.let {
                when (it) {
                    is NoConnectionError -> noConnection()
                    is ApiError -> onApiError(it)
                    is GenericError -> genericError()
                    else -> {
                        if (it is Unit)
                            onSuccessIgnoreResponse()
                        else
                            onSuccess.invoke(it as T)
                    }
                }
            }
        }
    }

    fun cancel() {
        result?.cancel()
    }
}