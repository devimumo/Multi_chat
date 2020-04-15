package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.util.Log
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class channel_list_insert {



    fun insert_data_to_channel_list_chats(data: String,context: Context) {

       // val data=remoteMessage.data["message"]

        val jsonObject=JSONObject(data)

Log.d("message_from",data)
        var channel_list_data = channel_list_entity()
        //var message_payload_data = channel_list_message_payload(0)


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

        channel_list_data.chat_snippet = chat_snippet;
        channel_list_data.current_user_phonenumber = current_user_phonenumber;
        channel_list_data.guest_phonenumber =guest_phonenumber ;
        channel_list_data.time_created = time_created;
        channel_list_data.time_sendorreceived = time_sendorreceived;
        channel_list_data.unique_id = unique_id
        channel_list_data.messageid = uuuuid
            channel_list_data.username = username;
        channel_list_data.time_in_unix = time_in_unix;



            //  val context=MainActivity()
        val instance = channel_list_db_instanse()
        instance.insert_data_to_db(context,channel_list_data)





    }

    fun update_data_to_channel_list(data: String, context: Context) {

     //   val data=remoteMessage.data["message"]

        val jsonObject=JSONObject(data)

        Log.d("message_from",data)
        var channel_list_data = channel_list_entity()
        //var message_payload_data = channel_list_message_payload(0)


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

        channel_list_data.chat_snippet = chat_snippet;
        channel_list_data.current_user_phonenumber = current_user_phonenumber;
        channel_list_data.guest_phonenumber =guest_phonenumber ;
        channel_list_data.time_created = time_created;
        channel_list_data.time_sendorreceived = time_sendorreceived;
        channel_list_data.unique_id = unique_id
        channel_list_data.messageid = uuuuid
        channel_list_data.username = username;
        channel_list_data.time_in_unix = time_in_unix;

Log.d("unique_id",unique_id)
        Log.d("time_in_unix",time_in_unix)


        //  val context=MainActivity()
        val instance = channel_list_db_instanse()
        instance.update_channel_list(context,channel_list_data)
    }

}