package com.alvarobrey.mqm

import com.alvarobrey.mqm.db.QuoteDAO
import com.alvarobrey.mqm.model.Quote
import com.alvarobrey.mqm.model.QuoteLine
import org.junit.Test

class SaveTest {
    @Test
    fun testSave() {
        //TODO in-memory database, asserts
        val quote = Quote(
            timestamp = System.currentTimeMillis(),
            lines = listOf(
                QuoteLine("test_author", "this is a test line")
            )
        )
        QuoteDAO.save(quote)
    }
}