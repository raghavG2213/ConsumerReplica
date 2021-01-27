package com.tcs.service.utility

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.tcs.service.model.ASN
import khttp.*

object Utility {
    fun convert(url: String, objectType: Any): MutableList<ASN>? {

        val jsonObject = get(url = url).jsonObject
        println(jsonObject)

        return when(true) {
            true -> {
                println("Hi")
                val mapper = ObjectMapper().registerKotlinModule()
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                when (objectType) {
                    is ASN -> {
                        println("SOME RESPONSE")
                        mapper.readValue(jsonObject["response"].toString(), Array<ASN>::class.java).toMutableList()
                    }
                    else -> {
                        null
                    }
                }
            }
            false -> {
                null
            }
        }
    }
}