package com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel_list_table")

data class channel_list_short_list_edited (
    @ColumnInfo
    var messageid:String="",
    @PrimaryKey
var unique_id: String=""
){


}