package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class contact_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)


        var contact_info = intent.getSerializableExtra("Contact info") as ArrayList<String>
        Log.d("Contact passed: ", contact_info.toString())
        val add_more= findViewById<Button>(R.id.button4)

        val recyclerView= findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)
        val data= ArrayList<ArrayList<String>>()
        if(contact_info!= null){
            var user = ArrayList<String>()
            user.add(contact_info.get(0))
            user.add(contact_info.get(1))
            user.add(contact_info.get(2))
            data.add(user)
        }

        val adapter =CustomAdapter(data)
        recyclerView.adapter=adapter

        add_more.setOnClickListener {
            intent = Intent(applicationContext,dashboard::class.java)
            startActivity(intent)
        }


    }
}