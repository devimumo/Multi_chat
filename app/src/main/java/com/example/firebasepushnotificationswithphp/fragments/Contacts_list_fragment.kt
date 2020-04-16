package com.example.firebasepushnotificationswithphp.fragments

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import com.example.firebasepushnotificationswithphp.R
import com.example.firebasepushnotificationswithphp.data_class.contact_data_class
import kotlinx.android.synthetic.main.contacts_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class Contacts_list_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view= inflater.inflate(R.layout.contacts_list, container, false)




    return view
    }


    fun contas(view: View)
    {

        var listView = view.contacts_list

       /* val contactModelArrayList = ArrayList<contact_data_class>()

        val phones = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC")
        while (phones!!.moveToNext()) {
            val name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

            val contactModel = ContactModel()
            contactModel.setNames(name)
            contactModel.setNumbers(phoneNumber)
            contactModelArrayList!!.add(contactModel)
            Log.d("name>>", name + "  " + phoneNumber)
        }
        phones.close()

        customAdapter = CustomAdapter(this, contactModelArrayList!!)
        listView!!.adapter = customAdapter*/
    }

    }



