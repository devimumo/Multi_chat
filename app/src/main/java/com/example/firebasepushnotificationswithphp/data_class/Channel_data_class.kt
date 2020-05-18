package com.example.firebasepushnotificationswithphp.data_class

class Channel_data_class(
    val chat_snippet: String,
    val current_user_phonenumber: String,
    val guest_phonenumber: String,
    val time_in_unix: String,
    val time__: String,
    val unique_id: String,
    val username: String,
    val read_status_count: Int=0
) {
}