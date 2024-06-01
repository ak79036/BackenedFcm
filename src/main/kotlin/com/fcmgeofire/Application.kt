package com.fcmgeofire

import com.fcmgeofire.plugins.*
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureRouting()
 // we have to link  our backend to our fcm server for authorizing
    val serviceaccountstream=this::class.java.classLoader.getResourceAsStream("service_account_key.json")
    // refering the service account key with the stream
      val options= FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceaccountstream)).build()

    FirebaseApp.initializeApp(options)
    // properly authenticate the client app
}
