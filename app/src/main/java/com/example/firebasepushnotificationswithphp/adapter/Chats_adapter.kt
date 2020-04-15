package com.example.firebasepushnotificationswithphp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.data_class.Channel_data_class
import com.example.firebasepushnotificationswithphp.data_class.Chats_data_class
import kotlinx.android.synthetic.main.chat_channel_list.view.*
import kotlinx.android.synthetic.main.layout.view.*
import java.util.ArrayList

class Chats_adapter (var channel_list: ArrayList<Chats_data_class>, val c: Context): RecyclerView.Adapter<Chats_adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Chats_adapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false)


        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
return  channel_list.size

    }

    override fun onBindViewHolder(holder: Chats_adapter.ViewHolder, position: Int) {

        val user_data: Chats_data_class=channel_list[position]


       // holder?.itemview.rem
        holder?.itemview.message.text=user_data.chat_snippet
        holder?.itemview.time_send.text=user_data.time_in_unix
        holder?.itemview.username_.text=user_data.username

        holder.itemview.setOnClickListener {

         //   Toast.makeText(c,"how now"+user_data.message,Toast.LENGTH_LONG).show()
        }



    }

    class ViewHolder(val itemview: View):RecyclerView.ViewHolder(itemview) {

    }

}