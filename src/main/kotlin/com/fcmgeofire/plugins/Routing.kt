package com.fcmgeofire.plugins

import com.fcmgeofire.sendNotification
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        // here we define our routes so that https request publicly receives json body from the app and then forward this to fcm
        sendNotification()
    }
}
