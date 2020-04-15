package com.example.firebasepushnotificationswithphp.data_class

import androidx.room.ColumnInfo

class Chats_data_class(


    var messageid:String="" ,

    var unique_id: String="",
    //time channel was created column
    var time_created: String="",
    //current user phone number
    var current_user_phonenumber: String="",
    // guest phone number
    var guest_phonenumber: String="",

    var chat_snippet: String="",
//
    var time_sendorreceived: String="",
    var time_in_unix: String="",

    var username: String=""
) {
}