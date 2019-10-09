package com.alvarobrey.mqm.db

import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

object DB {
    //TODO parameterize
    private const val DB_NAME = "mqm"
    private val HOST = System.getenv("DB_HOST") ?: "mongo"
    private val PORT = System.getenv("DB_PORT") ?: "27017"

    //TODO parameters for mongo initialization
    val instance: MongoDatabase by lazy {
        KMongo.createClient(
                host = HOST,
                port = PORT.toInt()
        ).getDatabase(DB_NAME)
    }
}