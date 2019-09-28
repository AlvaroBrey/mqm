package com.alvarobrey.mqm.db

import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

object DB {
    //TODO parameterize
    private const val DB_NAME = "mqm"
    //TODO parameters for mongo initialization
    val instance: MongoDatabase by lazy { KMongo.createClient().getDatabase(DB_NAME) }
}