package com.alvarobrey.mqm.model

import java.util.*

data class QuoteLine(val author: String, val line: String)

// TODO better ID gen, timezones
data class Quote(
    val uri: String = UUID.randomUUID().toString(),
    val timestamp: Long,
    val createdAt: Long = System.currentTimeMillis(),
    val lines: List<QuoteLine>,
    val points: Int = 0
)