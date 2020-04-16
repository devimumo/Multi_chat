package com.example.firebasepushnotificationswithphp.work
var unique_ids: String=""

class Unique_id {

    fun get_unique_id(receiver_phonenumber: String,sender_phonenumber: String): String
    {

        if (receiver_phonenumber>sender_phonenumber)
        {

             unique_ids=receiver_phonenumber+"."+sender_phonenumber

        }
        else
        {

             unique_ids=sender_phonenumber+"."+receiver_phonenumber

        }

        return unique_ids

    }
}