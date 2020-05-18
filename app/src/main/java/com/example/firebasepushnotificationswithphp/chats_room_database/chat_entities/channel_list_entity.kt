package com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.firebasepushnotificationswithphp.R
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "channel_list_table")
// this describes the columns  that will be contained in the stated table
data class channel_list_entity(
    // a unique id for this chat channel


    @ColumnInfo
    var messageid:String="" ,
    @PrimaryKey
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

    @ColumnInfo(name= "read_status_count")
    var read_status_count: Int=0
){

}