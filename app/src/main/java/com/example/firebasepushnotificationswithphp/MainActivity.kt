package com.example.firebasepushnotificationswithphp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.room.Room
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_chat_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_message_payload
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db.channel_list_db
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.example.firebasepushnotificationswithphp.work.channel_list_insert
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import java.security.Timestamp
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ////////////////////////////////////
      /*  FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("refused", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                // val msg = getString(R.string.msg_token_fmt, token)
                Log.d("agreed", token)
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })*/


        /*
        val instance_id=MyFirebaseInstanceIDService()
        instance_id.onTokenRefresh(applicationContext)*/

        delete_from_channel_list.setOnClickListener {
CoroutineScope(Dispatchers.IO).launch {
//Toast.makeText(it.context,"its done",Toast.LENGTH_SHORT).show()

               delete()
            }
        }
        button3.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{

                insert_channel_list_data_in_background()
            }
        }


    }


    /*  fun retreive(view: View) {
       // val refreshedToken = FirebaseInstanceId.getInstance().getToken()
      //  Toast.makeText(this,refreshedToken,Toast.LENGTH_LONG).show()

      //  Log.d("angalia",refreshedToken)


       Thread{
            val cccg= channel_list_insert()
            cccg.insert_channel_list(this)
           val unique_id="+254713836954."+guest_phone.text

            var channel_list_data= channel_list_entity()
            var message_payload_data= channel_list_message_payload(0)


           val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
           val currentDate = sdf.format(Date())
         //  val unique_id="+254713836954.+254c723401134".plus(currentDate);

         //  data.time_created=currentDate
           var uuuuid="+254713836954.+254723401134".plus(currentDate)



            channel_list_data.chat_snippet="";
            channel_list_data.current_user_phonenumber="";
            channel_list_data.guest_phonenumber="";
            channel_list_data.time_created="";
            channel_list_data.time_sendorreceived="";
            channel_list_data.unique_id=unique_id
            channel_list_data.messageid=uuuuid

            val instance= channel_list_db_instanse()
val vv=  instance.select_user_data(this)


           val gson = Gson()
           val gsonPretty = GsonBuilder().setPrettyPrinting().create()
           val jsonTutsList: String = gson.toJson(vv)

           val jsonTutsListPretty: String = gsonPretty.toJson(vv)
       Log.d("gson",vv)


          //  instance.check_if_unique_user_id_exists(this,message_payload_data,channel_list_data,unique_id)
        }.start()





    }*/

suspend fun delete()
{
    val instance = channel_list_db_instanse()
    instance.delete_from_channel_list(this)
}

    private suspend fun insert_channel_list_data_in_background() {

        //  instance.check_if_unique_user_id_exists(this,message_payload_data,channel_list_data,unique_id)
        val unique_id = "+254713836954." + guest_phone.text

        var channel_list_data = channel_list_entity()
        var message_payload_data = channel_list_message_payload(0)


        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        //  val unique_id="+254713836954.+254c723401134".plus(currentDate);

        //  data.time_created=currentDate
        var uuuuid = "+254713836954.+254723401134".plus(currentDate)


        channel_list_data.chat_snippet = "nimekam kwa keja";
        channel_list_data.current_user_phonenumber = "713836954";
        channel_list_data.guest_phonenumber = "799722933";
        channel_list_data.time_created = "220000";
        channel_list_data.time_sendorreceived = "220000";
        channel_list_data.unique_id = unique_id
        channel_list_data.messageid = uuuuid

        val instance = channel_list_db_instanse()
      //  instance.insert_data_to_db(this,message_payload_data, channel_list_data  )

    }
}

