package com.example.firebasepushnotificationswithphp.launcher_actions

import android.content.Context
import android.util.Log
import android.view.View
import com.example.firebasepushnotificationswithphp.work.Update_firebase_instance_id
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

class Get_Instanse_id {

    fun get_instanse_id(context: Context, phone_number: String, username: String?) {

     //   val conte = context
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("refused", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                // val msg = getString(R.string.msg_token_fmt, token)
                Log.d("agreed", token)
                if (token != null) {

                    // val vii=View(context)
                    var send_to_server = Update_firebase_instance_id()

                    send_to_server.update_instance_id(context, token, phone_number, username)
                }

                //  Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
    }

}