package io.github.gunkim

import io.github.gunkim.framework.plugins.configureMonitoring
import io.github.gunkim.framework.plugins.configureRouting
import io.github.gunkim.framework.plugins.configureSecurity
import io.github.gunkim.framework.plugins.configureSerialization
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
