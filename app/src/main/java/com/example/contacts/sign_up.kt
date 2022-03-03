package com.example.contacts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val button=findViewById<Button>(R.id.button2)
        val emailTV = findViewById<EditText>(R.id.emailAddressET)
        val passwordTV =findViewById<EditText>(R.id.password)
        var email = emailTV.text
        var pwd = passwordTV.text
        var user_info= arrayOf(email,pwd)

        var db = openOrCreateDatabase("AccountDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(email VARCHAR,password VARCHAR);");



        val tv8=findViewById<TextView>(R.id.textView8)
        tv8.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("Credentials",user_info)
            startActivity(intent)
        }
        button.setOnClickListener {
            if ((emailTV.text.isEmpty())||(passwordTV.text.isEmpty())) {
                Toast.makeText(this, "Please Enter Both Credentials", Toast.LENGTH_LONG).show()
            }
            else {
                Log.d("emailLog", user_info?.get(0).toString());
                db.execSQL(
                    "INSERT INTO user VALUES('" + user_info?.get(0) + "','" + user_info?.get(
                        1
                    ) + "');"
                );
                Toast.makeText(this, "Accounted Created", Toast.LENGTH_SHORT).show()
            }
        }

    }
}