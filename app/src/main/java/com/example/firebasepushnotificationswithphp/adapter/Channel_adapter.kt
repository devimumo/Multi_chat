package com.example.firebasepushnotificationswithphp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.data_class.Channel_data_class
import kotlinx.android.synthetic.main.chat_channel_list.view.*
import java.util.ArrayList

class Channel_adapter (var channel_list: ArrayList<Channel_data_class>,val c: Context): RecyclerView.Adapter<Channel_adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Channel_adapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.chat_channel_list,parent,false)


        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
return  channel_list.size

    }

    override fun onBindViewHolder(holder: Channel_adapter.ViewHolder, position: Int) {
        val user_data: Channel_data_class=channel_list[position]

        holder?.itemview.username.text=user_data.username
        holder?.itemview.chat_snippet.text=user_data.chat_snippet
        holder?.itemview.time_sendorreceived.text=user_data.time_sendorreceived
        holder?.itemview.guest_phone.text=user_data.guest_phonenumber




    }

    class ViewHolder(val itemview: View):RecyclerView.ViewHolder(itemview) {

    }

}