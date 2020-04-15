package com.example.firebasepushnotificationswithphp.work

import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class send_message {

    fun send_message(
        remote_json: String,
        view: View
    )
    {

        Log.d("fcm_response","imefinywa")

        val requestQueue= Volley.newRequestQueue(view.context)

        val url="https://project-daudi.000webhostapp.com/ladies_group/fcm/fcm.php?&message_payload_json="+remote_json

        Log.d("remote_one",remote_json)
        val stringRequest=object : StringRequest(Request.Method.GET,url,
            Response.Listener { responsess->

                Log.d("fcm_response",responsess)

            }
            , Response.ErrorListener {

                val error_handler= Volley_ErrorListener_Handler()
                Log.d("volley_error",it.toString())
                error_handler.check_error(it,view)
            })
        {}
        requestQueue.add(stringRequest)

    }


}