package com.fcmgeofire

import com.google.firebase.messaging.FirebaseMessaging
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// just an extension version of routes
fun Route.sendNotification() {
    route("/send") {
        post {
            // working on json body we get from client side
            val body = call.receiveNullable<SendMessageDto>() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
                // if there is no json body attached
            }

            FirebaseMessaging.getInstance().send(body.toMessage())
            // function call so that the body message converts into that message which is gonna recieves by client side

            call.respond(HttpStatusCode.OK)
        }
    }
    route("/broadcast") {
        post {
            val body = call.receiveNullable<SendMessageDto>() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            FirebaseMessaging.getInstance().send(body.toMessage())

            call.respond(HttpStatusCode.OK)
        }
    }
}