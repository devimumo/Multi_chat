package com.example.firebasepushnotificationswithphp.service

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.firebasepushnotificationswithphp.*
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db.channel_list_db
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.example.firebasepushnotificationswithphp.work.Chats_payload_insert
import com.example.firebasepushnotificationswithphp.work.Check_users_existense
import com.example.firebasepushnotificationswithphp.work.Insert_intersected_contacts
import com.example.firebasepushnotificationswithphp.work.channel_list_insert
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import io.reactivex.annotations.SchedulerSupport.IO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*


class Handle_mesu: FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage) { // ...
        super.onMessageReceived(remoteMessage)
val cont=applicationContext
        val db = Room.databaseBuilder(applicationContext, channel_list_db::class.java, "chat__db").build()

// TODO(developer): Handle FCM messages here.
// Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        val mes = remoteMessage.data["message"];


        // Check if message contains a data payload.
        if (remoteMessage.data.size > 0) {
            Log.d("mesu", "Message data payload: " + remoteMessage.from)
            if ( /* Check if data needs to be processed by long running job */true) { // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                val data = remoteMessage.data["message"]

               var check_check_id_instanse=Check_users_existense()
                if (data != null) {

                    val jsonObject = JSONObject(data)
                    val from_ = jsonObject.getString("from")

                    if (from_.equals("chats"))
                    {
                        check_check_id_instanse.check_if_user_exists(data,"guest",cont)

                    }
                    else
                    {

                        var contact_insert_instanse=Insert_intersected_contacts()
                        contact_insert_instanse.insert_data_to_contacts_payload(data,cont)

                    }

                }

            } else { // Handle message within 10 seconds
                // handleNow()
            }
        }
        // Check if message contains a notification payload.
        if (remoteMessage.notification != null) {
            Log.d("noti", "Message Notification Body: " + remoteMessage.notification!!.body)
        }
        // Also if you intend on generating your own notifications as a result of a received FCM
// message, here is where that should be initiated. See sendNotification method below.
    }


    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */

   /* suspend fun scheduleJob(remoteMessage: RemoteMessage,context: Context) {
        val data = remoteMessage.data["message"]
        val jsonObject = JSONObject(data)
        val unique_id = jsonObject.getString("unique_id")
Log.d("unique_one",unique_id)
val instanse=channel_list_db_instanse()
    //check whether data set witha unique id is available.
        //if its not(false) then the channel list data payload is added
        //if its true the the channel list row is updated


        val check_unique=instanse.check_if_unique_user_id_exists(unique_id,context)
        if (check_unique==false)
        {
            val channel_list_in=channel_list_insert()

            channel_list_in.insert_data_to_channel_list_chats(remoteMessage,context)

            var chats_payload_insert=Chats_payload_insert()
            if (data != null) {
                chats_payload_insert.insert_data_to_chats_payload(data,context,"guest")
            }
        }
        else
        {



            val channel_list_in=channel_list_insert()
            channel_list_in.update_data_to_channel_list(remoteMessage,context)

            var chats_payload_insert=Chats_payload_insert()
            if (data != null) {
                chats_payload_insert.insert_data_to_chats_payload(data,context,"guest")
            }

        }



        //  channel_list_data.unique_id=unique_id
        //   channel_list_data.messageid=uuuuid


    }*/
}