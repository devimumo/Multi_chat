package com.example.firebasepushnotificationswithphp.ui.chats_list

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasepushnotificationswithphp.Hosting_activity
import com.example.firebasepushnotificationswithphp.Launcher
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.adapter.Channel_adapter
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.example.firebasepushnotificationswithphp.data_class.Channel_data_class
import com.example.firebasepushnotificationswithphp.fragments.Chats_fragment
import com.example.firebasepushnotificationswithphp.fragments.Contacts_list_fragment
import com.example.firebasepushnotificationswithphp.launcher_actions.Get_Instanse_id
import com.example.firebasepushnotificationswithphp.work.Unique_id
import com.example.firebasepushnotificationswithphp.work.Update_firebase_instance_id
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.fragment_chats_list.view.*
import kotlinx.android.synthetic.main.get_preferences.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
val mesu = ArrayList<Channel_data_class>()
//var contribution_dataa = Channel_data_class("","","","","")

val instance= channel_list_db_instanse()
var root_view: View? =null
class Chatfragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // val rec: RecyclerView=channel_list_recycler_view.

        root_view = inflater.inflate(R.layout.fragment_chats_list, container, false)





        var vv= root_view

        vv?.button4?.setOnClickListener {
            instance.select_contacts_payload(vv.context)
        }
        vv?.floating_action_button?.setOnClickListener {


         //   var instanses=Unique_id()
         //   var uniqueIdii= instanses.get_unique_id("254731763426","254713836954")
      //      Toast.makeText(vv.context,"floating"+uniqueIdii,Toast.LENGTH_LONG).show()
            val frg=Contacts_list_fragment()

            Toast.makeText(vv.context,"inastarnsact",Toast.LENGTH_LONG).show()

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.hosting_container, frg,"grgg")?.addToBackStack("backstack")?.commit()


        }

        if (vv != null) {

            root_view?.context?.let { instance.select_user_data(it) }

        }


        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                onBackPressed()

            }
        })

        return root_view
    }



    fun onBackPressed()
    {

        var context=activity?.applicationContext

        Log.d("alerted","nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn")



     /*   var builder=activity.applicationContext{->AlertDialog.Builder(activity.applicationContext)}
        builder?.setMessage("Are you sure yo want to exit?")
            ?.setPositiveButton(R.string.exit_positive,
                DialogInterface.OnClickListener { dialog, id ->
                    // FIRE ZE MISSILES!

            })
            ?.setNegativeButton(R.string.cancel,
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
        // Create the AlertDialog object and return it
        builder?.create()*/


    }

    suspend fun retreive_channel_list_payload(channel_list_payload:String) {
        //getting channel list from db instanse

        var root_view= root_view
        // val channel_list_payload = root_view?.context?.let { instance.select_user_data(it) }

        if (channel_list_payload != null) {
            if (channel_list_payload.isEmpty()) {
                if (root_view != null) {
                  //  get_username_phone_number(root_view)
                }

            } else {
                Log.d("channel_list_payload",channel_list_payload+"this is the message")


                //  mesu.clear()
               // Log.d("recycler","starting on recycler")
                if (root_view != null) {
                    if (channel_list_payload != null) {
                        chat_fragment(root_view, channel_list_payload)
                    }
                }
                if (root_view != null) {
                   // get_username_phone_number(root_view)
                }

            }
        }
    }






    fun chat_fragment(view: View, vv: String) {
//withContext(Main){
        // mesu.clear()

        var view= root_view

        // adap.notifyDataSetChanged()

        val recycler_view = view?.channel_list_recycler_view



        val time_form = SimpleDateFormat("hh:mm:ss")
        val time_retreived = time_form.format(Date())
        Log.d("channel_list_json", "time retreived:" + time_retreived + "\n" + vv)


        val jsonObject = JSONArray(vv)
//    val data = jsonObject.getJSONArray(0)

        // mesu.clear()
        mesu.clear()

        for (i in 0..jsonObject.length() - 1) {


            val contributions_data = jsonObject.getJSONObject(i)
            var contribution_dataa = Channel_data_class(
                contributions_data.getString("chat_snippet"),
                contributions_data.getString("current_user_phonenumber"),

                contributions_data.getString("guest_phonenumber"),
                contributions_data.getString("time_in_unix"),
                contributions_data.getString("time_sendorreceived"),
                contributions_data.getString("unique_id"),
                contributions_data.getString("username"),
                        contributions_data.getInt("read_status_count")


            )

           var counts=
               view?.context?.let {
                   instance.select_message_payload_status(
                       it,contributions_data.getString("unique_id")
                   )
               }
            Log.d("guest_phonenumber",counts.toString()+"--"+contribution_dataa.guest_phonenumber.toString())

            val adap = view?.context?.let { Channel_adapter(mesu, it) }
            if (adap != null) {
                adap.notifyDataSetChanged()
            }

            mesu.add(contribution_dataa)
            if (recycler_view != null) {
                if (view != null) {
                    recycler_view.layoutManager = LinearLayoutManager(view.context)
                }
            }
//            adap.notifyDataSetChanged()
            if (recycler_view != null) {
                recycler_view.adapter = adap
            }
            // (recycler_view.layoutManager as LinearLayoutManager).setStackFromEnd(true);

        }

        //val recycler_view : RecyclerView= channel_list_recycler_view



    }




}
//  chat_fragment(view,vv)


