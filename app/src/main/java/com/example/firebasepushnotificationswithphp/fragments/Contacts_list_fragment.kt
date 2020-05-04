package com.example.firebasepushnotificationswithphp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.adapter.Contacts_intersected_adapter
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.example.firebasepushnotificationswithphp.data_class.contacts_data_class
import com.example.firebasepushnotificationswithphp.ui.chats_list.Chatfragment
import com.example.firebasepushnotificationswithphp.ui.chats_list.mesu
import kotlinx.android.synthetic.main.contacts_list.view.*
import kotlinx.android.synthetic.main.hosting_activity.*
import org.json.JSONArray
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 */
var views: View? =null
var contacts_db_instanse=channel_list_db_instanse()
var contacts_payload_arraylist=ArrayList<contacts_data_class>()
class Contacts_list_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        views = inflater.inflate(R.layout.contacts_list, container, false)

        activity?.nav_view?.visibility=View.GONE

        var views_cast= views
        if (views_cast != null) {
            contacts_db_instanse.select_contacts_payload(views_cast.context)
        }

      //  requestPermission(view)



    activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressed()
        }
    })


    return views_cast
}

fun onBackPressed(){


    val frg= Chatfragment()


    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.hosting_container, frg,"grgg")?.addToBackStack("grgg")?.commit()
    activity?.nav_view?.visibility=View.VISIBLE


}















    fun contacts_list_recycler( vv: String)
    {

        Log.d("imefika_hapa","imefika hapa")

        var views_cast= views

        val recycler_view = views_cast?.contacts_list



        val jsonObject = JSONArray(vv)
        mesu.clear()
        chats_payload_arraylist.clear()


        for (i in 0..jsonObject.length() - 1) {


            val contacts_data_string = jsonObject.getJSONObject(i)
            var contacts_data = contacts_data_class(
                contacts_data_string.getString("phonenumber"),

                contacts_data_string.getString("name")



            )
            Log.d("imefika_phone",jsonObject.length().toString()+contacts_data_string.getString("name"))




            contacts_payload_arraylist.add(contacts_data)

            val adap = views_cast?.context?.let { Contacts_intersected_adapter(contacts_payload_arraylist, it)
            }
            recycler_view?.layoutManager = LinearLayoutManager(views_cast?.context)
            adap?.notifyDataSetChanged()
            recycler_view?.adapter = adap
          /*  if (recycler_view != null) {
                (recycler_view.layoutManager as LinearLayoutManager).setStackFromEnd(true)
            }*/

        }

        //val recycler_view : RecyclerView= channel_list_recycler_view






    }



}





