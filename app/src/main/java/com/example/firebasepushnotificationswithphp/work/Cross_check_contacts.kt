package com.example.firebasepushnotificationswithphp.work

import android.content.Context
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.firebasepushnotificationswithphp.chats_room_database.chat_room_db_instanse.channel_list_db_instanse
import com.example.firebasepushnotificationswithphp.data_class.contacts_update_data_class
import com.example.firebasepushnotificationswithphp.fragments.contacts_db_instanse
import com.google.gson.Gson
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.util.HashMap

var conts= ArrayList<String>()

class Cross_check_contacts {




    fun network_io_for_crosscheck (context: Context,contacts_list_json: String)
    {



// var contacts_list_json="[\"254732340665\",\"254732340665\",\"254713836954\",\"254713836954\",\"254713836954\",\"254713836954\",\"40111\",\"40111\",\"9000\",\"9000\",\"254706651053\",\"254706651053\",\"254706651053\",\"254706651053\",\"254735522899\",\"254735522899\",\"254735522899\",\"254735522899\",\"254706248105\",\"254706248105\",\"254706248105\",\"254706248105\",\"254738461373\",\"254738461373\",\"254713836954\",\"254713836954\",\"254713836954\",\"254713836954\",\"254713836954\",\"254713836954\",\"254733909925\",\"254733909925\",\"AIRTEL\",\"AIRTEL\",\"254713179693\",\"254713179693\",\"254713179693\",\"254713179693\",\"254713179693\",\"254713179693\",\"254724 864609\",\"254724 864609\",\"254724864609\",\"254724864609\",\"254724864609\",\"254724864609\",\"254722978401\",\"254722978401\",\"254722978401\",\"254722978401\",\"254722978401\",\"254722978401\",\"254725308896\",\"254725308896\",\"254725308896\",\"254725308896\",\"254725308896\",\"254725308896\",\"254738852654\",\"254738852654\",\"MPESA\",\"MPESA\",\"1127900684\",\"1127900684\",\"254720252944\",\"254720252944\",\"254720252944\",\"254720252944\",\"254724 533473\",\"254724 533473\",\"254724533473\",\"254724533473\",\"254724533473\",\"254724533473\",\"254724533473\",\"254724533473\",\"254717214783\",\"254717214783\",\"254717214783\",\"254717214783\",\"254714650657\",\"254714650657\",\"254714650657\",\"254714650657\",\"254716551597\",\"254716551597\",\"254716551597\",\"254716551597\",\"254700142461\",\"254700142461\",\"254713048630\",\"254713048630\",\"254713048630\",\"254713048630\",\"254 702 283681\",\"254 702 283681\",\"254702283681\",\"254702283681\",\"254780276012\",\"254780276012\",\"254780276012\",\"254780276012\",\"254707306910\",\"254707306910\",\"254707306910\",\"254707306910\",\"971506586242\",\"971506586242\",\"971506586242\",\"971506586242\",\"254715604084\",\"254715604084\",\"254726089791\",\"254726089791\",\"254726089791\",\"254726089791\",\"254726089791\",\"254726089791\",\"254720 651004\",\"254720 651004\",\"254705 875302\",\"254705 875302\",\"254705875302\",\"254705875302\",\"254720583646\",\"254720583646\",\"254720583646\",\"254720583646\",\"254738183333\",\"254738183333\",\"254738183333\",\"254738183333\",\"254716330335\",\"254716330335\",\"254716330335\",\"254716330335\",\"254791924367\",\"254791924367\",\"254791924367\",\"254791924367\",\"254710445442\",\"254710445442\",\"254710445442\",\"254710445442\",\"254728663493\",\"254728663493\",\"254728663493\",\"254728663493\",\"254728663493\",\"254728663493\",\"254713885900\",\"254713885900\",\"254 716 260982\",\"254 716 260982\",\"254716260982\",\"254716260982\",\"254 718 840947\",\"254 718 840947\",\"254727480014\",\"254727480014\",\"254727480014\",\"254727480014\",\"254710164939\",\"254710164939\",\"254710164939\",\"254710164939\",\"254710164939\",\"254710164939\",\"254705584383\",\"254705584383\",\"254705584383\",\"254705584383\",\"254705584383\",\"254705584383\",\"254722 834874\",\"254722 834874\",\"254722834874\",\"254722834874\",\"254713046948\",\"254713046948\",\"254704809289\",\"254704809289\",\"254726499182\",\"254726499182\",\"254726499182\",\"254726499182\",\"254726499182\",\"254726499182\",\"254788417909\",\"254788417909\",\"254788417909\",\"254788417909\",\"254788417909\",\"254788417909\",\"254721811128\",\"254721811128\",\"254721811128\",\"254721811128\",\"254725 602712\",\"254725 602712\",\"254723450130\",\"254723450130\",\"254723450130\",\"254723450130\",\"254725561169\",\"254725561169\",\"254725561169\",\"254725561169\",\"254725561169\",\"254725561169\",\"254725561169\",\"254725561169\",\"254725561169\",\"254725561169\",\"254706249639\",\"254706249639\",\"254706249639\",\"254706249639\",\"254701365162\",\"254701365162\",\"254701365162\",\"254701365162\",\"254701365162\",\"254701365162\",\"971 56 175 3672\",\"971 56 175 3672\",\"971561753672\",\"971561753672\",\"254704407117\",\"254704407117\",\"254704407117\",\"254704407117\",\"254704407117\",\"254704407117\",\"254711240723\",\"254711240723\",\"254711240723\",\"254711240723\",\"254727731928\",\"254727731928\",\"254727731928\",\"254727731928\",\"254727641674\",\"254727641674\",\"254727641674\",\"254727641674\",\"254741091166\",\"254741091166\",\"254741091166\",\"254741091166\",\"254703 906049\",\"254703 906049\",\"254703906049\",\"254703906049\",\"254775 829279\",\"254775 829279\",\"254 731 909864\",\"254 731 909864\",\"254731909864\",\"254731909864\",\"254786304723\",\"254786304723\",\"254786304723\",\"254786304723\",\"254721246118\",\"254721246118\",\"254707599496\",\"254707599496\",\"254721565419\",\"254721565419\",\"254721565419\"]\n";
        val requestQueue= Volley.newRequestQueue(context)
     // val url="https://project-daudi.000webhostapp.com/ladies_group/fcm/cross_check_contacts.php?&phone_contacts="+contacts_list_json
      //  val url="http://192.168.1.130:8080/canary_camera/cross_checker.php?&phone_contacts="+contacts_list_json
         val url="https://project-daudi.000webhostapp.com/ladies_group/fcm/cross_check_contacts.php?"

        val stringRequest=object : StringRequest(
            Request.Method.POST,url,
            Response.Listener { response->

Log.d("cross_check_response",response)

                contacts_to_array(context,response)


            }, Response.ErrorListener {

                val error_handler= Volley_ErrorListener_Handler()
            //    error_handler.check_error(it,view)
                Log.d("error_handler",it.toString())

            }){

            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> =
                    HashMap()

                params["phone_contacts"]=contacts_list_json

                                                return params
            }

        }




        requestQueue.add(stringRequest)
    }


    fun contacts_to_array( context: Context,cont: String)
    {

     var   contsss= JSONArray(cont)
     //   var cc=contsss.getJSONObject(0)
      for (i in 0..contsss.length()-1)
        {
            var cc=contsss[i]


            var jsonss = Gson()
            var contact_list = jsonss.toJson(cc)
         contact_list= contact_list.replace("\"","")
            Log.d("contact_list",contact_list)
            conts.add(contact_list.toString())

            var db_instanse= channel_list_db_instanse()
CoroutineScope(Dispatchers.IO).launch {
    db_instanse.update_contact_list_num(context,contact_list)


}

        }



     /*   var db_instanse= channel_list_db_instanse()
        db_instanse.update_contact_list(context,conts)*/
    }
}

private fun <E> ArrayList<E>.add(element: JSONObject?) {

}
