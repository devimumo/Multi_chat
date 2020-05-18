package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.util.Log
import android.view.View
import com.example.firebasepushnotificationswithphp.Hosting_activity
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.example.firebasepushnotificationswithphp.fragments.Chats_fragment
import com.example.firebasepushnotificationswithphp.ui.chats_list.Chatfragment
import com.example.firebasepushnotificationswithphp.ui.chats_list.instance
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class Check_users_existense

{
    fun check_if_user_exists(data: String,from: String,context: Context)
    {

        CoroutineScope(Dispatchers.IO).launch {

            scheduleJob(data,from,context)
        }
    }


    suspend fun scheduleJob(data: String, from:String,context: Context) {
        val jsonObject = JSONObject(data)
        val unique_id = jsonObject.getString("unique_id")
        Log.d("unique_one",data)
        val instanse= channel_list_db_instanse()
        //check whether data set witha unique id is available.
        //if its not(false) then the channel list data payload is added
        //if its true the the channel list row is updated


        val check_unique=instanse.check_if_unique_user_id_exists(unique_id,context)
        if (check_unique==false)
        {
            val channel_list_in=channel_list_insert()

            channel_list_in.insert_data_to_channel_list_chats(data,context)

            var chats_payload_insert=Chats_payload_insert()
            if (data != null) {
                chats_payload_insert.insert_data_to_chats_payload(data,context,from)
            }

          //  var view: Chatfragment =Chatfragment()
         //   var vv=view.activity
          //   instance.select_user_data(View.C)
            val frg= Chats_fragment()

instanse.select_user_data(context)

            var instanse=channel_list_db_instanse()
            instanse.select_message_payload_data(context,unique_id)


         //   var instanseed: Chatfragment =Chatfragment()
         //   instanseed.call_uuu(context)


        }
        else
        {


            Log.d("unique_one",data)

            val channel_list_in=channel_list_insert()
            channel_list_in.update_data_to_channel_list(data,context)

            var chats_payload_insert=Chats_payload_insert()
            if (data != null) {
                chats_payload_insert.insert_data_to_chats_payload(data,context,from)
            }


            var instanse=channel_list_db_instanse()
            instanse.select_message_payload_data(context,unique_id)

            instanse.select_user_data(context)


            // var instanseed: Chatfragment =Chatfragment()
//instanseed.call_uuu(context)

        }



        //  channel_list_data.unique_id=unique_id
        //   channel_list_data.messageid=uuuuid


    }

}