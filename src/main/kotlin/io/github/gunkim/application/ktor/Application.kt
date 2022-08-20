package io.github.gunkim.application.ktor

import io.github.gunkim.application.ktor.plugins.configureMonitoring
import io.github.gunkim.application.ktor.plugins.configureRouting
import io.github.gunkim.application.ktor.plugins.configureSecurity
import io.github.gunkim.application.ktor.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureMonitoring()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
