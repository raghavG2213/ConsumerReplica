package com.tcs.service.repo

import com.tcs.service.model.ECMR


interface CustomRepository {

    fun findAllByQueryParams(shipmentId: String?): List<ECMR>?


}