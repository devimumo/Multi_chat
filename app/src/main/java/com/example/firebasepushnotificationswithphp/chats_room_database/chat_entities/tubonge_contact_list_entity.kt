package com.example.firebasepushnotificationswithphp.chats_room_database.chat_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tubonge_contact_list_table")
  data class  tubonge_contact_list_entity(

  @PrimaryKey(autoGenerate = true)
  var contact_id: Int=0,
  @ColumnInfo
  var name: String="",
  @ColumnInfo
  var phonenumber: String=""

){


}