package com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
    // this describes the columns  that will be contained in the stated table
    data class channel_list_chat_entity(
        // a unique id for this chat channel
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
        var guest_phonenumber: String=""


    ){

}