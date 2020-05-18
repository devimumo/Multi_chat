package com.example.firebasepushnotificationswithphp.chats_room_database.chats_room_DAO

import androidx.room.*
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.contact_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.tubonge_contact_list_entity

@Dao
interface contact_list_dao {

       @Insert(onConflict= OnConflictStrategy.REPLACE)
    abstract fun insert_contact_list_data(vararg insert_contact_list_data: contact_list_entity)

    @Transaction
fun insert(vararg insert_contact_list_data: contact_list_entity)
    {
        insert_contact_list_data(*insert_contact_list_data)
    }



    //insert cross checked contacts function
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    abstract fun tubonge_insert_contact_list_data(vararg tubonge_insert_contact_list_data: tubonge_contact_list_entity)

    @Transaction
    fun tubonge_insert(vararg tubonge_insert_contact_list_data: tubonge_contact_list_entity)
    {
        tubonge_insert_contact_list_data(*tubonge_insert_contact_list_data)
    }

  //  @Query("SELECT * FROM contact_list_table WHERE (registered LIKE (:jinaa) AND contact_id=(SELECT MAX(contact_id) FROM contact_list_table ))")


    @Query("SELECT * FROM contact_list_table WHERE registered LIKE (:jinaa)")

    fun getAll(jinaa:String) : List<contact_list_entity>



    @Query("SELECT * FROM contact_list_table WHERE phonenumber LIKE (:jinaa)")
    fun check_existense(jinaa: String) : List<contact_list_entity>

    @Query(value = "UPDATE contact_list_table SET registered = :regs  WHERE phonenumber =(:phonenumberss)")
   abstract fun update_contact_list_num(regs: String,phonenumberss: String)


  /*  @Query("UPDATE contact_list_table set phonenumber=2547317634266  WHERE phonenumber LIKE (:phonenumber)")

    fun update_contact_list_num(regs: String,phonenumber: String) {
Log.d("sevd","sevd")
    }*/


    @Query("DELETE FROM contact_list_table")
    fun delete_contact_list_table()

}