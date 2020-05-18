package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.util.Log
import android.view.View
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.util.HashMap

class send_message {

    fun send_message(
        remote_json: String,
        view: View
    )
    {


        val requestQueue= Volley.newRequestQueue(view.context)

    //    val url="https://project-daudi.000webhostapp.com/ladies_group/fcm/fcm.php?&message_payload_json="+remote_json

        val url="https://project-daudi.000webhostapp.com/ladies_group/fcm/fcm.php"


        Log.d("remote_one",remote_json)
        val stringRequest=object : StringRequest(Request.Method.POST,url,
            Response.Listener { responsess->

                Log.d("fcm_response",responsess)

            }
            , Response.ErrorListener {

                val error_handler= Volley_ErrorListener_Handler()
                Log.d("volley_error",it.toString())
                error_handler.check_error(it,view)
            })
        {

            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> =
                    HashMap()


                params["message_payload_json"] = remote_json

                return params
            }

        }
        requestQueue.add(stringRequest)

    }


}