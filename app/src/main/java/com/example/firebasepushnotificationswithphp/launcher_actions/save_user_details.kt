package com.example.firebasepushnotificationswithphp.launcher_actions

import android.content.Context

class save_user_details {

     fun save_user_details(context: Context, phoneNumber: String, username: String) {

        val MyPreferences = "Chats"
        val sharedPreferences =
            context?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)

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