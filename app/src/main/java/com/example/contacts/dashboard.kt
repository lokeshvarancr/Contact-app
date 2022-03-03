package com.example.contacts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.ArrayList

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val name_d= findViewById<EditText>(R.id.textView)
        val email_d= findViewById<EditText>(R.id.emailAddress)
        val phone_d= findViewById<EditText>(R.id.number)




        val add= findViewById<Button>(R.id.addBtn)

        add.setOnClickListener {
            var list = arrayListOf<String>(name_d.text.toString(),email_d.text.toString(),phone_d.text.toString())
            intent = Intent(applicationContext,contact_list::class.java)
            intent.putExtra("Contact info",list)
            startActivity(intent)
        }
    }
}