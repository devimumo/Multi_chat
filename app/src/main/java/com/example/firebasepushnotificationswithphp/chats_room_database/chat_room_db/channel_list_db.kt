package com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_chat_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_message_payload
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.contact_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chats_room_DAO.chat_channel_list_DAO
import com.example.firebasepushnotificationswithphp.chats_room_database.chats_room_DAO.contact_list_dao


//val kk=arrayOf(channel_list_chat_entity::class).toString()

//var contacts= arrayOf(contact_list_entity::class)
@Database(version=1, entities =  [channel_list_message_payload::class , channel_list_chat_entity::class , channel_list_entity::class,contact_list_entity::class ] )
abstract class channel_list_db :RoomDatabase(){
    abstract fun chat_channel_list_DAO(): chat_channel_list_DAO


}