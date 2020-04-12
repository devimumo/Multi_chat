package com.example.firebasepushnotificationswithphp.ui.my_account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.firebasepushnotificationswithphp.Chats_activity
import com.example.firebasepushnotificationswithphp.MainActivity
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.ui.chats_list.Chatfragment
import kotlinx.android.synthetic.main.chat_channel_list.*
import kotlinx.android.synthetic.main.fragment_myaccount.*
import kotlinx.android.synthetic.main.fragment_myaccount.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class my_account_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val Mroot_view=         inflater.inflate(R.layout.fragment_myaccount, container, false)

/*Mroot_view.Save.setOnClickListener {

    CoroutineScope(Main).launch {
        get_username_and_password(Mroot_view)

    }
}*/
return Mroot_view
    }


   suspend fun get_username_and_password(Mroot_view: View){
        val MyPreferences = "Chats"
        val sharedPreferences = Mroot_view.context?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)
        val cc=Chats_activity()
        val editor = sharedPreferences?.edit()
        // String phone_number_= phone_number.getText().toString().trim();
        val user_name: String = Mroot_view.text_dashboard.text.toString()
        val phone_number: String = Mroot_view.phone_number.text.toString()


        editor?.remove("phone_number")
        editor?.remove("user_name")
        editor?.putString("phone_number", phone_number)
        editor?.putString("user_name", user_name)
        // editor.putString("phone_numbers",phone_number_);
        editor?.commit()
        // val intent=Intent(root_view.context,MainActivity::class.java)
        //startActivity(intent)

        val get_in=Chatfragment()
        get_in.get_instanse_id(Mroot_view,phone_number,user_name)
    }

}
