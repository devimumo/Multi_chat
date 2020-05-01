package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.provider.ContactsContract
import android.util.Log
import androidx.room.Room
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.contact_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db.contact_list_db
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


var name: String=""
var phonenumber: String=""
var contact_list_array=contact_list_entity()
var cross_check_contacts=com.example.firebasepushnotificationswithphp.work.Cross_check_contacts()
var phoneNumber: String=""
var contact_array_list= ArrayList<String>()
var contact_number_array_list= ArrayList<String>()
//var contactModelArrayList = contact_list_entity()
var contactModel_ArrayList_full = arrayListOf<contact_list_entity>()


class Retreive_contacts {




    fun contas(context: Context) {

      /*  android.widget.Toast.makeText(
            context,
            "imefika hapa",
            android.widget.Toast.LENGTH_LONG
        ).show()*/


        val phones = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )

            val db = Room.databaseBuilder(context, contact_list_db::class.java, "contacts_db").build()

CoroutineScope(Dispatchers.IO).launch {
    db.contact_list_dao().delete_contact_list_table()

}

            while (phones!!.moveToNext()) {

                name =
                    phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                phoneNumber =
                    phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))






                contact_number_array_list = get_number_only_json(phoneNumber)



                var phonenumber_set = phoneNumber.let { get_phone_number(it) }.toString()


                contact_list_array = contact_list_entity(
                    0, name, phonenumber_set,"crossed"
                )
                contactModel_ArrayList_full.add(contact_list_array)



             Log.d("contact_list_array", contact_list_array.toString())
                db.contact_list_dao().insert(contact_list_array )


            }


        var jsonss = Gson()
           var contact_list_jsons = jsonss.toJson(contact_number_array_list)
            var contactarray_list_jsons = jsonss.toJson(contactModel_ArrayList_full)
            Log.d("contact,,",contact_list_jsons)
       //     insert_contacts_data(contactarray_list_jsons, context, contact_list_array)

        cross_check_contacts.network_io_for_crosscheck(context,contact_list_jsons)

    //    iterate_contact_array(contactarray_list_jsons, context, contact_number_array_list, contactModel_ArrayList_full)



    }

    private fun iterate_contact_array(
        contactmodelArraylistFull: String,
        context: Context,
        contactNumberArrayList1: ArrayList<String>,
        contactmodelArraylistFull1: ArrayList<contact_list_entity>
    ) {


        for (i in 0..((contactmodelArraylistFull.length)/100)-1)
        {

            var from_int=0
            var to_int=100
            var sublisted=contactNumberArrayList1.subList(from_int,to_int)

            var jsonss = Gson()
            var contact_list_jsons = jsonss.toJson(sublisted)

            cross_check_contacts.network_io_for_crosscheck(context,contact_list_jsons)

               from_int=to_int+1
            to_int=from_int+100


                    }


    }


    fun get_phone_number(phonenumber_: String): String {

        var phonenumber = phonenumber_.replace("+", "");
        phonenumber = phonenumber.replace(" ", "");

        val test = phonenumber

        // used to check the first character of the mobile number retreived
        val s = test.substring(0, 1)
        if (s.equals("0")) {
            // replaces the zero in mobile number with 254
            var phonenumbers = "254" + phonenumber.substring(1);


            return phonenumbers
        } else {

            return phonenumber


        }

    }


    //returns a json array to be send to server to cross check contacts
    fun get_number_only_json(phonenumber_: String): ArrayList<String> {


        var phonenumber = phonenumber_.replace("+", "");
        phonenumber = phonenumber.replace(" ", "");

        val test = phonenumber

        // used to check the first character of the mobile number retreived
        val s = test.substring(0, 1)
        if (s.equals("0")) {
            // replaces the zero in mobile number with 254
            var phonenumbers = "254" + phonenumber.substring(1);
            contact_array_list.add(phonenumbers)


            return contact_array_list
        } else {
            contact_array_list.add(phonenumber)

            return contact_array_list


        }
    }

    fun get_chunks_of_number_array(originalList: Array<String>, chunkSize: Int) {



    }

}