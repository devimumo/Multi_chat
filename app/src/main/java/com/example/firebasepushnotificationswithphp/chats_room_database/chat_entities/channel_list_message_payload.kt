package com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel_list_message_payload_table")
data class channel_list_message_payload (  @PrimaryKey(autoGenerate = true)
                                           var id: Int,
                                           @ColumnInfo
                                           var unique_id: String="",
    //time channel was created column
                                           @ColumnInfo(name= "time_created")
                                           var time_send: String="",
    //current user phone number
                                           @ColumnInfo(name= "current_user_phonenumber")
                                           var current_user_phonenumber: String="",
    // guest phone number
                                           @ColumnInfo(name= "guest_phonenumber")
                                           var guest_phonenumber: String="",

                                           @ColumnInfo(name= "message")
                                           var message: String=""){


}