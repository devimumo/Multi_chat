package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.example.firebasepushnotificationswithphp.R
import java.text.SimpleDateFormat
import java.util.*


class Toast {

    fun toastAnywhere(text: String?,context: Context) {
        val handler = Handler(Looper.getMainLooper())
        handler.post(Runnable {




            Toast.makeText(context,text,Toast.LENGTH_LONG).show()
        })
    }
}