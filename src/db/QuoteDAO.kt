package com.alvarobrey.mqm.db

import com.alvarobrey.mqm.model.Quote
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection

object QuoteDAO {

    private val collection: MongoCollection<Quote> = DB.instance.getCollection<Quote>()

    fun all(): List<Quote> =
        collection.find()
            .fold(listOf<Quote>()) { acc, quote ->
                acc.plus(quote)
            }

    fun save(quote: Quote) =
        collection.insertOne(quote)

}