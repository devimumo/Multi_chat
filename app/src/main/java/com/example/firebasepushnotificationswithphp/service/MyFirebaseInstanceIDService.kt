package com.example.firebasepushnotificationswithphp.service

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessagingService


  class MyFirebaseInstanceIDService : FirebaseMessagingService()  {


      /**
       * Called if InstanceID token is updated. This may occur if the security of
       * the previous token had been compromised. Note that this is called when the InstanceID token
       * is initially generated so this is where you would retrieve the token.
       */
      override fun onNewToken(token: String) {
          Log.d("new_id", "Refreshed token: $token")
          // If you want to send messages to this application instance or
          // manage this apps subscriptions on the server side, send the
          // Instance ID token to your app server.
        //  sendRegistrationToServer(token)
      }


}