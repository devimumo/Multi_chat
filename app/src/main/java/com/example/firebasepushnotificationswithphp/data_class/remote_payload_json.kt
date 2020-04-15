package com.example.firebasepushnotificationswithphp.data_class

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel_list_message_payload_table")
data class remote_payload_json (




    //time channel was created column
    //current user phone number
    var time_sendorreceived: String="",
    var unique_id: String="",
    var current_user_phonenumber: String="",
    // guest phone number
    var guest_phonenumber: String="",

    var chat_snippet: String="",

    var username: String="",
    var time_in_unix: String=""

){

}