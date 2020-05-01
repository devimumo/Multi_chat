package com.example.firebasepushnotificationswithphp.launcher_actions

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import com.example.firebasepushnotificationswithphp.Hosting_activity
import com.example.firebasepushnotificationswithphp.Launcher
import com.example.firebasepushnotificationswithphp.R
import kotlinx.android.synthetic.main.get_preferences.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Get_phonenumber_username_alertdialog {




    fun get_username_phone_number(context: Context) {
        //   val view_HERE=getView()

        val MyPreferences = "Chats"
        val sharedPreferences =
            context?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)
        val phone_number = sharedPreferences?.getString("phone_number", "")
        val username = sharedPreferences?.getString("username", "user name")


        if (phone_number.equals("")) {

            Log.d("getting_d","there is no user details")

            Toast.makeText(context, "Please fill your user account details here", Toast.LENGTH_LONG).show()
            alertdialog(context)


        } else {
            val iintent= Intent(context, Hosting_activity::class.java)
            context.startActivity(iintent)
            CoroutineScope(Dispatchers.Main).launch {
                if (phone_number != null) {


                    //   get_instanse_id(view,phone_number,username)
                }
            }



        }
        // String session_ide= sharedPreferences.getString("sessions_ids","");

    }


    fun alertdialog(context: Context) {

       // var context = view.context
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.get_preferences, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)

            .setCancelable(false)
        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.save.setOnClickListener {
            val phone_number=mDialogView.phone_number.text.toString()
            val username=mDialogView.username.text.toString()
            var instanse_get_instanse_id=Get_Instanse_id()
GlobalScope.launch(Dispatchers.IO) {
    instanse_get_instanse_id. get_instanse_id(context,phone_number,username)

}
            val iintent= Intent(context, Hosting_activity::class.java)
            context.startActivity(iintent)
            mAlertDialog.dismiss()

        }
        //cancel button click of custom layout
       /* mDialogView.cancel.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
        }*/
    }



}