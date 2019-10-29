package com.rcorchero.footballplayers.data.exception

class NetworkConnectionException(errorMessage: String = "The connection has failed"):
    Exception(errorMessage)