package com.example.firebasepushnotificationswithphp.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.data_class.contacts_data_class
import com.example.firebasepushnotificationswithphp.fragments.Chats_fragment
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



            var phonenumber=user_data.phonenumber


            var username=user_data.names



            //   var time_sendorreceived=user_data.time_sendorreceived




            val activity = it.getContext() as AppCompatActivity
            val myFragment = activity.fragmentManager.findFragmentById(R.id.chat_frag)

            //sending data to chats fragment as we open the fragment


            val bundle = Bundle()
            // bundle.putString("username", user_data.username)
            bundle.putString("unique_id", "")
            bundle.putString("username", user_data.names)
            bundle.putString("phonenumber", user_data.phonenumber)

            bundle.putString("current_user_phonenumber", "")



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
