package com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse

import android.content.Context
import android.util.Log
import android.view.View
import androidx.room.Room.databaseBuilder
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_message_payload
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db.channel_list_db
import com.example.firebasepushnotificationswithphp.fragments.Chats_fragment
import com.example.firebasepushnotificationswithphp.ui.chats_list.Chatfragment
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

var statement_data: String=""
class channel_list_db_instanse {
    val toaster: com.example.firebasepushnotificationswithphp.work.Toast =
        com.example.firebasepushnotificationswithphp.work.Toast()

 fun  select_user_data(view: View, context: Context)
{

    CoroutineScope(Dispatchers.IO).launch {

        val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()

        val des=        db.chat_channel_list_DAO().select_data()
        val vvvv = Gson()

        var statement_data=vvvv.toJson(des).toString()
        Log.d("statement_data", "channel short list data converted to json"+statement_data)
      withContext(Main){
          val inu=Chatfragment()
          inu.retreive_channel_list_payload(view,statement_data)
      }
    }
}

    fun select_message_payload_data(view: View, context: Context,unique_id: String)
    {


            CoroutineScope(Dispatchers.IO).launch {

                val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()

                val mesu_payload=db.chat_channel_list_DAO().select_message_payload(unique_id)
                val vvvv = Gson()

                var message_payload=vvvv.toJson(mesu_payload).toString()
                Log.d("message_payload_data", "message payload data"+statement_data)
                withContext(Main){
                  val to_ui=Chats_fragment()
                   to_ui.chats_recycler_view(view,message_payload)
                }
            }

    }


    suspend fun check_if_unique_user_id_exists(unique_id: String ,context: Context   ):Boolean
    //if true then just insert the message payload to the db
    //if false then insert channel list data and then insert the message payload
    {

        var return_value: Boolean=true
//        val context_here= Channel_list_activity()

        withContext(Dispatchers.IO) {

            val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()
            //   db.chat_channel_list_DAO().insertAll_channel_list_data(channel_list_data)

            if (db.chat_channel_list_DAO().check_id(unique_id).size < 1) {
                val mese = "hakuna...........";
                //   toaster.toastAnywhere(mese, context)

                //     db.chat_channel_list_DAO().insertAll_message_payload(message_payload)
                return_value=false
                          } else {
                val mese = "iko...........";
                //  toaster.toastAnywhere(mese, context)
                //     db.chat_channel_list_DAO().insertAll_message_payload(message_payload)


                Log.d("uniq", "ina exist")
return_value=true
            }

        }

        return return_value

    }

       fun insert_data_to_db(context: Context,  channelListData: channel_list_entity) {

                val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()

                db.chat_channel_list_DAO().insertAll_channel_list_data(channelListData)

        }

       fun delete_from_channel_list(context: Context) {

CoroutineScope(Dispatchers.Default).launch {
    val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()
    db.chat_channel_list_DAO().delete_from_channel_list()

}


        }

    fun update_channel_list(context: Context, channelListData: channel_list_entity) {
        val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()
var username=channelListData.username
        var chat_snippet=channelListData.chat_snippet
        var timesendorreceived=channelListData.time_sendorreceived
        var time_in_unix=channelListData.time_in_unix
        var unique_id=channelListData.unique_id

       // username: String,chat_snippet: String,time_sendorreceived: String,unique_id: String,time_in_unix: String


        db.chat_channel_list_DAO().update_channel_list(username,chat_snippet,timesendorreceived,unique_id,time_in_unix)
        Log.d("unique_update",unique_id)
    }

    fun insert_data_chats_to_db(context: Context, chatsMessagePayload: channel_list_message_payload) {
        val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()

        db.chat_channel_list_DAO().insertAll_message_payload(chatsMessagePayload)
        Log.d("insert_chats",chatsMessagePayload.toString())
    }

}



