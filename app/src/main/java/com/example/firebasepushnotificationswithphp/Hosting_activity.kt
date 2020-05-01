package com.example.firebasepushnotificationswithphp

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.firebasepushnotificationswithphp.fragments.My_account_setting_fragment
import com.example.firebasepushnotificationswithphp.ui.chats_list.Chatfragment
import com.example.firebasepushnotificationswithphp.work.Retreive_contacts
import kotlinx.android.synthetic.main.hosting_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Hosting_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hosting_activity)
//createNotificationChannel()
        val frag= Chatfragment()
        supportFragmentManager.beginTransaction().replace(R.id.hosting_container,frag).commit()

        nav_view.setOnNavigationItemSelectedListener {



          when(it.itemId)
          {
              R.id.navigation_chats_list->
              {
                  val frag= Chatfragment()
                  supportFragmentManager.beginTransaction().replace(R.id.hosting_container,frag).commit()
              }
              R.id.navigation_myaccount->
              {
                  val frag= My_account_setting_fragment()
                  supportFragmentManager.beginTransaction().replace(R.id.hosting_container,frag).commit()
              }
          }
            return@setOnNavigationItemSelectedListener true
        }
    }





    private fun retreive_contacts(context: Context) {







    }

   /* private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }*/



    suspend fun call_not()
    {
withContext(Dispatchers.Main){

    val builder = NotificationCompat.Builder(applicationContext)
        .setSmallIcon(R.drawable.messu)
        .setContentTitle("Received message")
        .setContentText("Hello World!")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        // Set the intent that will fire when the user taps the notification
        //  .setContentIntent(pendingIntent)
        .setAutoCancel(true)
}

    }
}
