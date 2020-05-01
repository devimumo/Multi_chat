package com.example.firebasepushnotificationswithphp.chats_room_database.chats_room_DAO

import android.util.Log
import androidx.room.*
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.contact_list_entity

@Dao
interface contact_list_dao {

   @Insert(onConflict= OnConflictStrategy.REPLACE)
    abstract fun insert_contact_list_data(vararg insert_contact_list_data: contact_list_entity)

    @Transaction
fun insert(vararg insert_contact_list_data: contact_list_entity)
    {
        insert_contact_list_data(*insert_contact_list_data)
    }

    @Query("SELECT * FROM contact_list_table WHERE registered LIKE (:jinaa)")
     fun getAll(jinaa: String) : List<contact_list_entity>

    @Query(value = "UPDATE contact_list_table SET registered = :regs  WHERE phonenumber =(:phonenumberss)")
   abstract fun update_contact_list_num(regs: String,phonenumberss: String)


  /*  @Query("UPDATE contact_list_table set phonenumber=2547317634266  WHERE phonenumber LIKE (:phonenumber)")

    fun update_contact_list_num(regs: String,phonenumber: String) {
Log.d("sevd","sevd")
    }*/


    @Query("DELETE FROM contact_list_table")
    fun delete_contact_list_table()

}