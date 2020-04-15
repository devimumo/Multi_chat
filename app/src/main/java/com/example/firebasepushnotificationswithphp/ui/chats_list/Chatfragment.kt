package com.example.firebasepushnotificationswithphp.ui.chats_list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.adapter.Channel_adapter
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.example.firebasepushnotificationswithphp.data_class.Channel_data_class
import com.example.firebasepushnotificationswithphp.fragments.Chats_fragment
import com.example.firebasepushnotificationswithphp.work.Update_firebase_instance_id
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.fragment_chats_list.view.*
import kotlinx.android.synthetic.main.get_preferences.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
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

class Chatfragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // val rec: RecyclerView=channel_list_recycler_view.

        val root_view = inflater.inflate(R.layout.fragment_chats_list, container, false)



        instance.select_user_data(root_view,root_view.context)


        return root_view
    }

    suspend fun retreive_channel_list_payload(root_view: View?,channel_list_payload:String) {
        //getting channel list from db instanse
       // val channel_list_payload = root_view?.context?.let { instance.select_user_data(it) }

        if (channel_list_payload != null) {
            if (channel_list_payload.isEmpty()) {
                if (root_view != null) {
                    get_username_phone_number(root_view)
                }

            } else {
                Log.d("channel_list_payload",channel_list_payload+"this is the message")


                //  mesu.clear()
                Log.d("recycler","starting on recycler")
                if (root_view != null) {
                    if (channel_list_payload != null) {
                        chat_fragment(root_view, channel_list_payload)
                    }
                }
                if (root_view != null) {
                    get_username_phone_number(root_view)
                }

            }
        }
    }

     fun get_instanse_id(view: View, phone_number: String, username: String?) {

        val conte = context
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("refused", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                // val msg = getString(R.string.msg_token_fmt, token)
                Log.d("agreed", token)
                if (token != null) {

                    // val vii=View(context)
                    var send_to_server = Update_firebase_instance_id()

                    send_to_server.update_instance_id(view, token, phone_number, username)
                }

                //  Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
    }

    fun get_username_phone_number(view: View) {
        //   val view_HERE=getView()

        val MyPreferences = "Chats"
        val sharedPreferences =
            view?.context?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)
        val phone_number = sharedPreferences?.getString("phone_number", "")
        val username = sharedPreferences?.getString("username", "user name")


        if (phone_number.equals("")) {

            Log.d("getting_d","there is no user details")

            Toast.makeText(view.context, "cccccccccccccccccccccc", Toast.LENGTH_LONG).show()
            alertdialog(view)
            //val my_account_fragment: my_account_fragment= my_account_fragment()
            /*  val firstFragment = my_account_fragment()
    val transaction = getActivity()?.getSupportFragmentManager()?.beginTransaction();
    transaction?.add(R.id.navigation_myaccount, firstFragment)
    transaction?.addToBackStack(null);

    transaction?.commit()*/

        } else {


          CoroutineScope(Main).launch {
                if (phone_number != null) {


                             //   get_instanse_id(view,phone_number,username)
}
            }



        }
        // String session_ide= sharedPreferences.getString("sessions_ids","");

    }

    fun alertdialog(view: View) {

        var context = view.context
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.get_preferences, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)

            .setCancelable(false)
        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout
         mDialogView.save.setOnClickListener {
             val phone_number=mDialogView.phone_number.text.toString()
             val username=mDialogView.username.text.toString()
                 save_user_details(view,phone_number,username)
                 get_instanse_id(view,phone_number,username)
             mAlertDialog.dismiss()

         }
         //cancel button click of custom layout
         mDialogView.cancel.setOnClickListener {
             //dismiss dialog
             mAlertDialog.dismiss()
         }
    }

    private fun save_user_details(view: View, phoneNumber: String, username: String) {

        val MyPreferences = "Chats"
        val sharedPreferences =
            view?.context?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)

        val editor = sharedPreferences?.edit()
        // String phone_number_= phone_number.getText().toString().trim();
        editor?.remove("username")
        editor?.remove("phone_number")
        editor?.putString("phone_number", phoneNumber)
        editor?.putString("username", username)
        // editor.putString("phone_numbers",phone_number_);
        editor?.commit()


    }


    fun chat_fragment(view: View, vv: String) {
//withContext(Main){
        // mesu.clear()

        // adap.notifyDataSetChanged()

        val recycler_view = view.channel_list_recycler_view



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
                contributions_data.getString("username")


            )

            Log.d("guest_phonenumber",contribution_dataa.guest_phonenumber.toString())

            val adap = Channel_adapter(mesu, view.context)
            adap.notifyDataSetChanged()

            mesu.add(contribution_dataa)
            recycler_view.layoutManager = LinearLayoutManager(view.context)
//            adap.notifyDataSetChanged()
            recycler_view.adapter = adap
        }

        //val recycler_view : RecyclerView= channel_list_recycler_view



    }

    fun open_chats_fragment()
    {
        Log.d("fragment_c","its getting here")
        val fragment2: Fragment =  Chats_fragment();







    }


}
  //  chat_fragment(view,vv)


