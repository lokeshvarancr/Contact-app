package com.example.contacts


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R

class CustomAdapter(private val mlist:List<ArrayList<String>>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout, parent, false)

        return ViewHolder(view)
    }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val arrList = mlist[position]
            holder.tv_name.text = arrList.get(0)
            holder.tv_phone.text = arrList.get(1)
            holder.tv_email.text = arrList.get(2)
        }

        override fun getItemCount(): Int {
            return mlist.size
        }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val tv_name: TextView = itemView.findViewById(R.id.tv_name)
        val tv_phone: TextView = itemView.findViewById(R.id.tv_phone)
        val tv_email: TextView = itemView.findViewById(R.id.tv_email)
    }
    }
