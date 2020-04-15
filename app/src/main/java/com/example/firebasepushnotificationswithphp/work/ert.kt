package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.messaging.FirebaseMessagingService
import org.json.JSONObject

class ert : FirebaseMessagingService() {

  override   fun onNewToken(p0: String) {

      val MyPreferences = "Chats"
      val sharedPreferences =applicationContext.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)
      val phone_number = sharedPreferences?.getString("phone_number", "")
      val usernames = sharedPreferences?.getString("username", "user name")


var instanse=Update_firebase_instance_id()

      update_instance_id(p0,phone_number,usernames)
       Log.d("tokener",p0)
    }


    fun update_instance_id(instance_id: String,phoner:String?,username: String? ) {

//val view=Channel_list_activity()
//val phoner="713899899";
        Log.d("getting_details",phoner+username+"this is the message")

        val requestQueue= Volley.newRequestQueue(applicationContext)
        val url="https://project-daudi.000webhostapp.com/ladies_group/fcm/update_instanse_id.php?&instanse_id="+instance_id+"&phone_number="+phoner+"&username="+username
        // val url = "https://project-daudi.000webhostapp.com/ladies_group/lipa_online.php?loan_id="+loan_id+"&phone_number="+phone_number+"&amount="+amount

        val stringRequest=object : StringRequest(
            Request.Method.GET,url,
            Response.Listener { response->
                val jsonObject = JSONObject(response)
                val response=jsonObject.getString("server_response")
                Log.d("response",response)

                if (response.equals("successful"))
                {
                    Log.d("created_success","this is the new instanse id"+instance_id)
                }
                else
                {
                    Log.d("created_unsuccesful","its not created")
                }


            }, Response.ErrorListener {

                val error_handler= Volley_ErrorListener_Handler()
              //  error_handler.check_error(it,view)

                Log.d("error_handler",error_handler.toString())


            }){}




        requestQueue.add(stringRequest)
    }






}