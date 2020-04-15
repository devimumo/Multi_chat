package com.example.firebasepushnotificationswithphp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.adapter.Chats_adapter
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.example.firebasepushnotificationswithphp.data_class.Chats_data_class
import com.example.firebasepushnotificationswithphp.data_class.remote_payload_json
import com.example.firebasepushnotificationswithphp.ui.chats_list.mesu
import com.example.firebasepushnotificationswithphp.work.Check_users_existense
import com.example.firebasepushnotificationswithphp.work.Volley_ErrorListener_Handler
import com.example.firebasepushnotificationswithphp.work.send_message
import kotlinx.android.synthetic.main.fragment_chats_fragment.*
import kotlinx.android.synthetic.main.fragment_chats_fragment.view.*
import kotlinx.android.synthetic.main.hosting_activity.view.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 */

val chats_payload_arraylist = ArrayList<Chats_data_class>()

val instance= channel_list_db_instanse()

class Chats_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_chats_fragment, container, false)
        val adap = Chats_adapter(chats_payload_arraylist, view.context)



        val bundle = this.arguments
        if (bundle != null) {
            var username = bundle["username"].toString()
            var unique_id = bundle["unique_id"].toString()
            var current_user_phonenumber=bundle["current_user_phonenumber"].toString()
            var guest_phonenumber=bundle["guest_phonenumber"].toString()

            Log.d("chat_bundle",username)

            instance.select_message_payload_data(view,view.context,unique_id)

            Toast.makeText(view.context,username,Toast.LENGTH_LONG).show()
      //  view.username_here.text=username.toString()

        }


        view.send.setOnClickListener {
            var username = bundle?.get("username").toString()
            var unique_id = bundle?.get("unique_id").toString()
            var current_user_phonenumber= bundle?.get("current_user_phonenumber").toString()
            var guest_phonenumber= bundle?.get("guest_phonenumber").toString()

val message_to_send=chat_message.text.toString()

            val sdf = SimpleDateFormat(" hh:mm a")
            val sdf_time_created = SimpleDateFormat("yyyyMddhhmmss")

            val current_time = sdf.format(Date())
            val currentDate = sdf_time_created.format(Date())

            val MyPreferences = "Chats"
            val sharedPreferences =
                view?.context?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)
            val phone_number = sharedPreferences?.getString("phone_number", "")
            val usernames = sharedPreferences?.getString("username", " -----")

            var remote_json = JSONObject()
            try {
                remote_json.put("mesu", message_to_send)
                remote_json.put("unique_id", unique_id)
                remote_json.put("time_send", currentDate)
                remote_json.put("time_kutuma", current_time)
                remote_json.put("username", usernames)
                remote_json.put("sender_phone_number", current_user_phonenumber)
                remote_json.put("receiver_phone_number", guest_phonenumber)

            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val recycler_view = view.chats_list_recycler_view

            adap.notifyDataSetChanged()
            recycler_view.adapter = adap
var send_message_instanse=send_message()
              send_message_instanse.send_message(remote_json.toString(),view)
            var check_check_id_instanse= Check_users_existense()
            check_check_id_instanse.check_if_user_exists(remote_json.toString(),"resident",view.context)

            Log.d("currentDate",remote_json.toString())

        }

  return view
    }





fun chats_recycler_view(view: View, vv: String)
{

        val recycler_view = view.chats_list_recycler_view



        val time_form = SimpleDateFormat("hh:mm:ss")
        val time_retreived = time_form.format(Date())
        Log.d("chat_recycler", "time retreived:" + time_retreived + "\n" + vv)

    val jsonObject = JSONArray(vv)
        // mesu.clear()
        mesu.clear()
    chats_payload_arraylist.clear()


    for (i in 0..jsonObject.length() - 1) {


            val chats_data_strings = jsonObject.getJSONObject(i)
            var chats_data = Chats_data_class(
                chats_data_strings.getString("messageid"),
                chats_data_strings.getString("unique_id"),
                chats_data_strings.getString("time_created"),
                chats_data_strings.getString("current_user_phonenumber"),
                chats_data_strings.getString("guest_phonenumber"),

                chats_data_strings.getString("chat_snippet"),
                chats_data_strings.getString("time_sendorreceived"),
                    chats_data_strings.getString("time_in_unix"),
                chats_data_strings.getString("username")




            )
        val adap = Chats_adapter(chats_payload_arraylist, view.context)


            chats_payload_arraylist.add(chats_data)
            recycler_view.layoutManager = LinearLayoutManager(view.context)
            adap.notifyDataSetChanged()
            recycler_view.adapter = adap

        }

        //val recycler_view : RecyclerView= channel_list_recycler_view



    

}
}
