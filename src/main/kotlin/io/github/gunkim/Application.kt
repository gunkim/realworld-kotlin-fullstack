package io.github.gunkim

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.github.gunkim.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureMonitoring()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
