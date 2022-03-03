package com.example.contacts

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db = openOrCreateDatabase("AccountDB", Context.MODE_PRIVATE, null);
        var emailid = findViewById<EditText>(R.id.editTextTextEmailAddress)
        var password = findViewById<EditText>(R.id.editTextTextPassword)
        var button= findViewById<Button>(R.id.button)
        var tv4=findViewById<TextView>(R.id.textView4)

        button.setOnClickListener {
            if ((emailid.text.isEmpty())||(password.text.isEmpty())) {
                Toast.makeText(this, "Please Enter Both Credentials", Toast.LENGTH_LONG).show()
            }
            else
            {
                val c: Cursor = db.rawQuery(
                    "SELECT * FROM user WHERE email='" + emailid.getText().toString() + "' AND password='" + password.text.toString() + "';", null
                )

                if(c.count>0)
                {
                    intent = Intent(applicationContext, dashboard::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Please Enter Correct Credentials", Toast.LENGTH_LONG).show()

                }
            }

        }
        tv4.setOnClickListener{
            intent = Intent(applicationContext,sign_up::class.java)
            startActivity(intent)
        }

    }
}