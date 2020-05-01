package com.example.firebasepushnotificationswithphp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.work.Update_firebase_instance_id
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.fragment_myaccount.*
import kotlinx.android.synthetic.main.fragment_myaccount.view.*

/**
 * A simple [Fragment] subclass.
 */
class My_account_setting_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    var   root_view= inflater.inflate(R.layout.fragment_myaccount, container, false)




        root_view.save_button.setOnClickListener {

            var phone_number=root_view.phone_number_edittext.text.toString()
            var username=root_view.username_edittext.text.toString()


            get_instanse_id(root_view,phone_number,username)
            save_user_details(root_view,phone_number,username)

        }


return  root_view   }


    fun get_instanse_id(view: View, phone_number: String, username: String?) {

        val conte = context
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

                    send_to_server.update_instance_id(view.context, token, phone_number, username)
                }

                //  Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
    }

    private fun save_user_details(view: View, phoneNumber: String, username: String) {

        val MyPreferences = "Chats"
        val sharedPreferences =
            view?.context?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)

        val editor = sharedPreferences?.edit()
        // String phone_number_= phone_number.getText().toString().trim();
        editor?.remove("username")
        editor?.remove("phone_number")
        editor?.putString("phone_number", phoneNumber)
        editor?.putString("username", username)
        // editor.putString("phone_numbers",phone_number_);
        editor?.commit()


    }



}
