package com.tcs.service.model


data class ServiceResponse(
        var responseCode: String,
        var responseDescription: String,
        var response: Any?
)