package com.example.firebasepushnotificationswithphp

import android.Manifest
import android.Manifest.permission
import android.R
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firebasepushnotificationswithphp.launcher_actions.Get_phonenumber_username_alertdialog
import com.example.firebasepushnotificationswithphp.work.Retreive_contacts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Boolean



class Launcher : AppCompatActivity() {


    var get_phonenumber_from_sharedprefernces=Get_phonenumber_username_alertdialog()


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.firebasepushnotificationswithphp.R.layout.activity_launcher)

        var MyPreferences = "Chats"

        var prevStarted = "prevStarted"

        val sharedPreferences = this.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)

        var state=sharedPreferences.getBoolean(prevStarted, false)
        if (state.equals(false)) {

            requestPermission(this)

            val editor = sharedPreferences.edit()
            editor.putBoolean(prevStarted, Boolean.TRUE)
            editor.apply()
        } else {

            requestPermission(this)

        }

        this?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })

    }

    fun onback()
    {
          }

    @RequiresApi(Build.VERSION_CODES.P)
    fun requestPermission(context: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {



            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR)
                != PackageManager.PERMISSION_GRANTED) {

Toast.makeText(this,"",Toast.LENGTH_LONG).show()
            }
            else{


                CoroutineScope(Dispatchers.IO).launch {
                    var instanse= Retreive_contacts()
                    instanse.contas(context)
                }
                val iintent= Intent(context, Hosting_activity::class.java)
                context.startActivity(iintent)

            }
           /* if (permission == PackageManager.PERMISSION_GRANTED) {

                CoroutineScope(Dispatchers.IO).launch {
                    var instanse= Retreive_contacts()
                    instanse.contas(context)
                }
                val iintent= Intent(context, Hosting_activity::class.java)
                context.startActivity(iintent)


            } else
            {}*/
        }
        val permission =
            ContextCompat.checkSelfPermission(context, permission.READ_CONTACTS)
        if (permission == PackageManager.PERMISSION_GRANTED) {

            CoroutineScope(Dispatchers.IO).launch {
                var instanse= Retreive_contacts()
                instanse.contas(context)
            }
            val iintent= Intent(context, Hosting_activity::class.java)
            context.startActivity(iintent)


        } else {


            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
                android.widget.Toast.makeText(
                    context,
                    "Contact permission is needed",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 1)
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
         1 -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    CoroutineScope(Dispatchers.IO).launch {
                        var instanse= Retreive_contacts()
                        instanse.contas(applicationContext)
                    }

                    get_phonenumber_from_sharedprefernces.get_username_phone_number(this)

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    android.widget.Toast.makeText(
                        this,
                        "Contact permission is needed",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()

                  //  finish()
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }

    //on resume function

  /*  override fun onResume() {
        super.onResume()
        val sharedPreferences =
            this?.getSharedPreferences(MyPreferences, Context.MODE_PRIVATE)
        if (!sharedPreferences.getBoolean(prevStarted, false)) {


//            get_phonenumber_from_sharedprefernces.get_username_phone_number(this)
            requestPermission(this)


            val editor = sharedPreferences.edit()
            editor.putBoolean(prevStarted, Boolean.TRUE)
            editor.apply()
        } else {

           requestPermission(this)


        }
    }*/

}
