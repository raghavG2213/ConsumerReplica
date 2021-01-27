package com.tcs.service.repo

import com.tcs.service.model.ECMR
import org.springframework.data.mongodb.repository.MongoRepository

interface ECMRRepo: MongoRepository<ECMR, String> {
    fun findByMessageNo(msgNo: String)

}