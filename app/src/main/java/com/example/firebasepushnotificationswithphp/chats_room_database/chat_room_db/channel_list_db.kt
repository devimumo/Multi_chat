package com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_chat_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_entity
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.channel_list_message_payload
import com.example.firebasepushnotificationswithphp.chats_room_database.chats_room_DAO.chat_channel_list_DAO


//val kk=arrayOf(channel_list_chat_entity::class).toString()
@Database(entities = [channel_list_message_payload::class,channel_list_chat_entity::class,channel_list_entity::class], version = 1)
abstract class channel_list_db :RoomDatabase(){
    abstract fun chat_channel_list_DAO(): chat_channel_list_DAO


}