package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.firebasepushnotificationswithphp.Chats_activity
import org.json.JSONObject

class Update_firebase_instance_id
{


     fun update_instance_id(view: View,instance_id: String,phoner:String?,username: String? ) {

//val view=Chats_activity()
//val phoner="713899899";
        val requestQueue= Volley.newRequestQueue(view.context)
        val url="https://project-daudi.000webhostapp.com/ladies_group/fcm/update_instanse_id.php?&instanse_id="+instance_id+"&phone_number="+phoner+"&username="+username
        // val url = "https://project-daudi.000webhostapp.com/ladies_group/lipa_online.php?loan_id="+loan_id+"&phone_number="+phone_number+"&amount="+amount

         val stringRequest=object : StringRequest(Request.Method.GET,url,Response.Listener { response->

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
           error_handler.check_error(it,view)

        }){}




        requestQueue.add(stringRequest)
    }

}