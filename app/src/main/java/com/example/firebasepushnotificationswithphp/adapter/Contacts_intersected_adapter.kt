package com.example.firebasepushnotificationswithphp.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.data_class.contacts_data_class
import com.example.firebasepushnotificationswithphp.fragments.Chats_fragment
import com.example.firebasepushnotificationswithphp.work.Unique_id
import kotlinx.android.synthetic.main.chat_channel_list.view.*
import kotlinx.android.synthetic.main.contacts.view.*
import kotlin.collections.ArrayList


class Contacts_intersected_adapter(
    var contacts_list: ArrayList<contacts_data_class>,
    val c: Context): RecyclerView.Adapter<Contacts_intersected_adapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Contacts_intersected_adapter.ViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.contacts,parent,false)


     return ViewHolder(view)


    }

    override fun getItemCount(): Int {
return  contacts_list.size

    }

    override fun onBindViewHolder(holder: Contacts_intersected_adapter.ViewHolder, position: Int) {

        val user_data: contacts_data_class=contacts_list[position]

       // holder?.itemview.rem
        holder?.itemview.contacts_username.text=user_data.names
        holder?.itemview.contacts_phonenumber.text=user_data.phonenumber

        val MyPreferences = "Chats"
        val sharedPreferences =
            c?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)



        holder.itemview.setOnClickListener {

            val instanse=Chats_fragment()

            val activity = it.getContext() as AppCompatActivity
            val myFragment = activity.fragmentManager.findFragmentById(R.id.chat_frag)

            //sending data to chats fragment as we open the fragment

            val MyPreferences = "Chats"
            val sharedPreferences =
                it.context?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)


            val phone_number = sharedPreferences?.getString("phone_number", "")
            val usernames = sharedPreferences?.getString("username", " -----")

            val bundle = Bundle()
            // bundle.putString("username", user_data.username)
            bundle.putString("username", user_data.phonenumber)
          //  bundle.putString("phonenumber", user_data.phonenumber)



            bundle.putString("unique_id",
                phone_number?.let { it1 -> Unique_id().get_unique_id(user_data.names, it1) })
            bundle.putString("guest_phonenumber", user_data.names)

            Log.d("username",user_data.names+"--"+user_data.phonenumber+"--"+phone_number)

            bundle.putString("current_user_phonenumber", phone_number)





            val frg=Chats_fragment()
            frg.arguments=bundle

           var rest= activity.getResources().getIdentifier("frame_cont", "id",activity.getPackageName());
            activity.supportFragmentManager.beginTransaction().replace(R.id.hosting_container, frg,"grgg").addToBackStack("grgg").commit()
            // .replace(rest, frg).addToBackStack(null).commit()


        }



    }

    private fun switchContent(chatFrag: Int, mFragment: Chats_fragment) {

    }


    class ViewHolder(val itemview: View):RecyclerView.ViewHolder(itemview) {

    }

}

private operator fun Bundle?.invoke(bundle: Bundle) {

}
