package com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "channel_list_table")
data class channel_list_short_list(

   /* @ColumnInfo
    var messageid:String="" ,
    @PrimaryKey
    var unique_id: String="",
     var time_created: String="",
    //current user phone number
    @ColumnInfo(name= "current_user_phonenumber")*/

    @ColumnInfo(name= "username")
    var username: String="",
    //time channel was created column
    @ColumnInfo(name= "current_user_phonenumber")
    var current_user_phonenumber: String="",
    // guest phone number
    @ColumnInfo(name= "guest_phonenumber")
    var guest_phonenumber: String="",

    @ColumnInfo(name= "chat_snippet")
    var chat_snippet: String="",

    @ColumnInfo(name= "time_in_unix")
    var time_in_unix: String="",
//
    @ColumnInfo(name= "time_sendorreceived")
    var time_sendorreceived: String="",

    @ColumnInfo(name= "unique_id")
    var unique_id: String=""





    ) {
}