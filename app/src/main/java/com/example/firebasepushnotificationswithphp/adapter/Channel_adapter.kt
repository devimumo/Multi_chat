package com.example.firebasepushnotificationswithphp.adapter

import android.R.attr.author
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.replace
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.data_class.Channel_data_class
import com.example.firebasepushnotificationswithphp.fragments.Chats_fragment
import kotlinx.android.synthetic.main.chat_channel_list.view.*
import kotlinx.android.synthetic.main.hosting_activity.*
import kotlinx.android.synthetic.main.hosting_activity.view.*
import java.util.*


class Channel_adapter (var channel_list: ArrayList<Channel_data_class>,val c: Context): RecyclerView.Adapter<Channel_adapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Channel_adapter.ViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.chat_channel_list,parent,false)


     return ViewHolder(view)


    }

    override fun getItemCount(): Int {
return  channel_list.size

    }

    override fun onBindViewHolder(holder: Channel_adapter.ViewHolder, position: Int) {

        val user_data: Channel_data_class=channel_list[position]

       // holder?.itemview.rem
        holder?.itemview.username.text=user_data.username
        holder?.itemview.chat_snippet.text=user_data.chat_snippet
        holder?.itemview.time_sendorreceived.text=user_data.time_in_unix
        holder?.itemview.guest_phone.text=user_data.guest_phonenumber

        holder.itemview.setOnClickListener {

            val instanse=Chats_fragment()



            var unique_id=user_data.unique_id

            var guest_phonenumber=user_data.guest_phonenumber
            var time_in_unix=user_data.time_in_unix
            var username=user_data.username
            var current_user_phonenumber=user_data.current_user_phonenumber
            var chat_snippet=user_data.chat_snippet
            var time_sendorreceived=user_data.time__

            Log.d("guest","time_sendorreceived:"+time_sendorreceived)


            //   var time_sendorreceived=user_data.time_sendorreceived

            Log.d("unique_one",unique_id)



            val activity = it.getContext() as AppCompatActivity
            val myFragment = activity.fragmentManager.findFragmentById(R.id.chat_frag)
           // val frg=my_account_fragment()

            //sending data to chats fragment as we open the fragment
            val bundle = Bundle()
           // bundle.putString("username", user_data.username)
            bundle.putString("username", user_data.username)
            bundle.putString("unique_id", unique_id)
            bundle.putString("guest_phonenumber", user_data.guest_phonenumber)

            bundle.putString("current_user_phonenumber", user_data.current_user_phonenumber)


            val frg=Chats_fragment()
            frg.arguments=bundle

           var rest= activity.getResources().getIdentifier("frame_cont", "id",activity.getPackageName());
            activity.supportFragmentManager.beginTransaction()                .replace(R.id.hosting_container, frg,"grgg").addToBackStack("grgg").commit()
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
