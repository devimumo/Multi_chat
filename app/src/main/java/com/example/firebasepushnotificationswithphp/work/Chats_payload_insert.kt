package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.util.Log
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_message_payload
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class Chats_payload_insert {




    fun insert_data_to_chats_payload(data: String, context: Context,from: String) {

      //  val data=remoteMessage.data["message"]

        val jsonObject= JSONObject(data)

        var chats_message_payload = channel_list_message_payload()


        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val sdf_time_created = SimpleDateFormat("ddMyyyyhhmmss")

        val currentDate = sdf.format(Date())
        //  val unique_id="+254713836954.+254c723401134".plus(currentDate);

        //  data.time_created=currentDate
        var time_created=sdf_time_created.format(Date())

        var time_sendorreceived=jsonObject.getString("time_send")
        var unique_id=jsonObject.getString("unique_id")
        var current_user_phonenumber=jsonObject.getString("receiver_phone_number")
        var guest_phonenumber=jsonObject.getString("sender_phone_number")
        var chat_snippet=jsonObject.getString("mesu")
        var username=jsonObject.getString("username")
        var time_in_unix=jsonObject.getString("time_kutuma")


        var uuuuid = current_user_phonenumber+"."+guest_phonenumber.plus(currentDate)

        chats_message_payload.chat_snippet = chat_snippet;
        chats_message_payload.current_user_phonenumber = current_user_phonenumber;
        chats_message_payload.guest_phonenumber =guest_phonenumber ;
        chats_message_payload.time_created = time_created;
        chats_message_payload.time_sendorreceived = time_sendorreceived;
        chats_message_payload.unique_id = unique_id
        chats_message_payload.messageid = uuuuid
        chats_message_payload.username = username;
        chats_message_payload.time_in_unix = time_in_unix;
        chats_message_payload.from=from
        chats_message_payload.read_status="not_rade"



        //  val context=MainActivity()
        val instance = channel_list_db_instanse()
        instance.insert_data_chats_to_db(context,chats_message_payload)





    }

}