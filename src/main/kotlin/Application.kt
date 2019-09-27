package com.alvarobrey.mqm

import com.alvarobrey.mqm.db.QuoteDAO
import com.alvarobrey.mqm.model.Quote
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        anyHost() // @TODO: limit this once we have docker deploy setup
    }

    install(ContentNegotiation) {
        jackson()
    }

    install(StatusPages) {
        exception<RuntimeException> { ex ->
            call.application.environment.log.error(ex.message ?: "", ex)
            call.respond(HttpStatusCode.InternalServerError, mapOf("ok" to false, "error" to (ex.message ?: "")))
        }
    }

    routing {
        get("/status") {
            call.respond(mapOf("ok" to true))
        }
        get("/quotes") {
            call.respond(
                mapOf(
                    "ok" to true,
                    "result" to QuoteDAO.all()
                )
            )
        }
        post("/quote") {
            val quote = call.receive<Quote>()
            QuoteDAO.save(quote)
            call.respond(
                mapOf(
                    "ok" to true,
                    "result" to quote
                )
            )
        }
    }
}

