package com.example.firebasepushnotificationswithphp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasepushnotificationswithphp.fragments.My_account_setting_fragment
import com.example.firebasepushnotificationswithphp.ui.chats_list.Chatfragment
import kotlinx.android.synthetic.main.hosting_activity.*

class Hosting_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hosting_activity)

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
}
