package com.example.firebasepushnotificationswithphp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.data_class.Chats_data_class
import kotlinx.android.synthetic.main.layout.view.*
import kotlinx.android.synthetic.main.layout.view.message
import kotlinx.android.synthetic.main.layout.view.time_send
import kotlinx.android.synthetic.main.layout.view.username_
import kotlinx.android.synthetic.main.layout_2.view.*
import java.util.ArrayList

class Chats_adapter (var channel_list: ArrayList<Chats_data_class>, val c: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //val view= LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false)


        if (viewType==1)
        {
            val view= LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false)

            return Chats_adapter.ViewHolder_one(view)

        }
        else
        {


            val view= LayoutInflater.from(parent.context).inflate(R.layout.layout_2,parent,false)

            return Chats_adapter.Guest_viewholder(view)

        }



    }

    override fun getItemCount(): Int {
return  channel_list.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val user_data: Chats_data_class=channel_list[position]



        if (holder.itemViewType==2)
        {
            var holder_resident=holder as Guest_viewholder


            holder_resident?.itemview.message_2.text=user_data.chat_snippet
            holder_resident?.itemview.time_send_2.text=user_data.time_in_unix
            holder_resident?.itemview.username_2.text=user_data.username
        }
        else
        {




        /*    var holder_resident=holder as ViewHolder_one


            holder_resident?.itemview.message.text=user_data.chat_snippet
            holder_resident?.itemview.time_send.text=user_data.time_in_unix
            holder_resident?.itemview.username_.text=user_data.username*/


            var holder_guest=holder as ViewHolder_one
            holder_guest?.itemview.message.text=user_data.chat_snippet
            holder_guest?.itemview.time_send.text=user_data.time_in_unix
            holder_guest?.itemview.username_.text=user_data.username
        }



 }


    override fun getItemViewType(position: Int): Int {
        val user_data: Chats_data_class=channel_list[position]
        Log.d("holder",user_data.from)

        if (user_data.from.equals("resident"))
        {
            Log.d("holder",user_data.from)


            return 1

        }


        return 2
    }




 class ViewHolder_one(var itemview: View):RecyclerView.ViewHolder(itemview) {

 }

 class Guest_viewholder(var itemview: View) :RecyclerView.ViewHolder(itemview) {

 }

}