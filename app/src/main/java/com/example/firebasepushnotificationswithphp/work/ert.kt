package com.example.firebasepushnotificationswithphp.work

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class ert : FirebaseMessagingService() {

  override   fun onNewToken(p0: String) {


       Log.d("tokener",p0)
    }

}