package com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.firebasepushnotificationswithphp.Chats_activity
import com.example.firebasepushnotificationswithphp.MainActivity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_chat_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_message_payload
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_short_list
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db.channel_list_db
import com.example.firebasepushnotificationswithphp.data_class.Channel_data_class
import com.google.gson.Gson
import io.reactivex.annotations.SchedulerSupport.IO
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import kotlin.collections.ArrayList

var statement_data_json: String=""
val statement_data = ArrayList<channel_list_short_list>()
class channel_list_db_instanse {
    val toaster: com.example.firebasepushnotificationswithphp.work.Toast =
        com.example.firebasepushnotificationswithphp.work.Toast()

 fun  select_user_data(context: Context): String
{

    CoroutineScope(Dispatchers.IO).launch {

        val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()
        val cc = db.chat_channel_list_DAO().select_data()
        db.chat_channel_list_DAO().select_data().forEach {


            val channel_list_dataaa = channel_list_short_list(

                it.current_user_phonenumber,
                it.guest_phonenumber,
                it.time_sendorreceived,
                it.username,
                it.chat_snippet
            )
            statement_data.add(channel_list_dataaa)

        }
        val vv = Gson()
        statement_data_json = vv.toJson(statement_data).toString()
    }
    return statement_data_json.toString()
}
    suspend fun check_if_unique_user_id_exists(unique_id: String ,context: Context   ):Boolean
    //if true then just insert the message payload to the db
    //if false then insert channel list data and then insert the message payload
    {

        var return_value: Boolean=true
//        val context_here= Chats_activity()

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

       fun insert_data_to_db(context: Context, messagePayloadData: channel_list_message_payload, channelListData: channel_list_entity) {

                val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()

                db.chat_channel_list_DAO().insertAll_channel_list_data(channelListData)

        }

    suspend   fun delete_from_channel_list(context: Context) {
            val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()
            db.chat_channel_list_DAO().delete_from_channel_list()

        }

    fun update_channel_list(context: Context, messagePayloadData: channel_list_message_payload, channelListData: channel_list_entity) {
        val db = databaseBuilder(context, channel_list_db::class.java, "chat__db").build()
var username=channelListData.username
        var chat_snippet=channelListData.chat_snippet
        var timesendorreceived=channelListData.time_sendorreceived
        var unique_id=channelListData.unique_id




        db.chat_channel_list_DAO().update_channel_list(username,chat_snippet,timesendorreceived,unique_id)
    }

}



