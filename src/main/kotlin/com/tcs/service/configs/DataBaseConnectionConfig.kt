package com.tcs.service.configs

import com.mongodb.ConnectionString
import org.springframework.data.mongodb.core.MongoTemplate
import com.mongodb.client.MongoClients
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient


object DataBaseConnectionConfig {

//
//    fun mongo(): MongoClient? {
//
//        val conn = "mongodb://ecmr-cosmosmongoapi-dbaccount:nFpJEKXlDWZaJHgkesO4KpI372vt5jjBWpMSo7ZVk7FbI46SyZSl8X1YW5NtksyFT3oRfpLvFW9DhJ0KLCfytw==@ecmr-cosmosmongoapi-dbaccount.mongo.cosmos.azure.com:10255/?ssl=true&replicaSet=globaldb&retrywrites=false&maxIdleTimeMS=120000&appName=@ecmr-cosmosmongoapi-dbaccount@"
//
//        val connectionString = ConnectionString(conn)
//
//        val mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build()
//
//        return MongoClients.create(mongoClientSettings)
//    }
//
//
//    fun mongoTemplate(): MongoTemplate {
//
//        return MongoTemplate(mongo()!!, "ecmrdb")
//    }
}