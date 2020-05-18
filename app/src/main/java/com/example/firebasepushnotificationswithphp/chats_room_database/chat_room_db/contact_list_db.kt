package com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.*
import com.example.firebasepushnotificationswithphp.chats_room_database.chats_room_DAO.chat_channel_list_DAO
import com.example.firebasepushnotificationswithphp.chats_room_database.chats_room_DAO.contact_list_dao


//val kk=arrayOf(channel_list_chat_entity::class).toString()

//var contacts= arrayOf(contact_list_entity::class)
@Database( entities = arrayOf(contact_list_entity::class,tubonge_contact_list_entity::class) ,version=1 ,exportSchema = false)
public abstract class contact_list_db :RoomDatabase(){
   public abstract fun contact_list_dao(): contact_list_dao


}