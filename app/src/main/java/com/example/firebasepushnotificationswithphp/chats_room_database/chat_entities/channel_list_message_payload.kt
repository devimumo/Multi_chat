package com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel_list_message_payload_table")
data class channel_list_message_payload (


    @PrimaryKey(autoGenerate = true)
    var chats_id:Int=0 ,
    @ColumnInfo
    var messageid:String="" ,
    @ColumnInfo
    var unique_id: String="",
    //time channel was created column
    @ColumnInfo(name= "time_created")
    var time_created: String="",
    //current user phone number
    @ColumnInfo(name= "current_user_phonenumber")
    var current_user_phonenumber: String="",
    // guest phone number
    @ColumnInfo(name= "guest_phonenumber")
    var guest_phonenumber: String="",

    @ColumnInfo(name= "chat_snippet")
    var chat_snippet: String="",
//
    @ColumnInfo(name= "time_sendorreceived")
    var time_sendorreceived: String="",
    @ColumnInfo(name= "time_in_unix")
    var time_in_unix: String="",

    @ColumnInfo(name= "username")
    var username: String="",
    //
    @ColumnInfo(name= "from")
    var from: String=""

){

}