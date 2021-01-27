package com.tcs.service.repo

import com.tcs.service.model.ECMR
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class CustomRepositoryImpl(private val mongoTemplate: MongoTemplate) : CustomRepository {

//    private val mongoTemplate: MongoTemplate = DataBaseConnectionConfig().mongoTemplate()

    override fun findAllByQueryParams(shipmentId: String?): List<ECMR>?{

        val queryObject = Query()
        val criteria1 = Criteria.where("shipmentId").isEqualTo(shipmentId)
        queryObject.addCriteria(criteria1)


         print(queryObject)

        return mongoTemplate.find(queryObject,ECMR::class.java)
    }

}