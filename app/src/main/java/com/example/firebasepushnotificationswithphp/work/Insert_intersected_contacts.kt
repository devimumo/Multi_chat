package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.contact_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import org.json.JSONArray
import org.json.JSONObject

class Insert_intersected_contacts {

    fun insert_data_to_contacts_payload(data: String, context: Context) {

        //  val data=remoteMessage.data["message"]

        val jsonObject= JSONObject(data)

     
        var username=jsonObject.getString("username")
        var phonenumber=jsonObject.getString("phonenumber")

        var intersected_contact_list_payload = contact_list_entity()


        intersected_contact_list_payload.name = username;
        intersected_contact_list_payload.phonenumber = phonenumber;



        //  val context=MainActivity()
        val instance = channel_list_db_instanse()
       // instance.insert_contact_list(context,intersected_contact_list_payload)





    }


    fun update_intersected_contacts(data: String, context: Context)
    {
        val jsonObject_array= JSONArray(data)
        var contact_intersected_list: ArrayList<String>?=ArrayList<String>();

        for (i in 0..jsonObject_array.length()-1)
        {

            contact_intersected_list?.add(jsonObject_array.getString(i))
        }


        val instance = channel_list_db_instanse()
        if (contact_intersected_list != null) {
           // instance.update_contact_list(context,contact_intersected_list)
        }

        //var username=jsonObject.getString("username")
      //  var phonenumber=jsonObject.getString("phonenumber")

        var intersected_contact_list_payload = contact_list_entity()


    }
}