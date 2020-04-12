package com.example.firebasepushnotificationswithphp.chats_room_database.chats_room_DAO

import androidx.room.*
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities.*
import io.reactivex.Completable


@Dao
interface chat_channel_list_DAO {

    @Query("SELECT * FROM channel_list_message_payload_table")
    fun select_message_payload(): List<channel_list_message_payload>

    @Query("SELECT * FROM channel_list_chat_entity")
    fun getAll(): List<channel_list_chat_entity>

    @Query("SELECT unique_id,messageid FROM channel_list_table WHERE unique_id LIKE (:unique_id)")
     fun check_id(unique_id: String): List<channel_list_short_list_edited>


    @Query("SELECT * FROM channel_list_table")
    fun select_data(): List<channel_list_short_list>

    @Query("DELETE FROM channel_list_table")
    fun delete_from_channel_list()

  @Insert
    fun insertAll(vararg users: channel_list_chat_entity)

    @Insert
    fun insertAll_channel_list_data(vararg users_channel_list_datas: channel_list_entity)

    @Insert
    fun insertAll_message_payload(vararg users_message_payloads: channel_list_message_payload)

    @Query("UPDATE channel_list_table SET username = :username, chat_snippet = :chat_snippet ,time_sendorreceived= :time_sendorreceived WHERE unique_id =:unique_id")
    fun update_channel_list(username: String,chat_snippet: String,time_sendorreceived: String,unique_id: String)





}