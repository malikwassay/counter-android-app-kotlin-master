package com.example.counterapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.counterapp.Model.Time
import com.example.counterapp.R

class mainscreenAdapter(private var mContext: Context,
                        private var mTime: List<Time>,
                        private var isFragment: Boolean = false): RecyclerView.Adapter<mainscreenAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainscreenAdapter.ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.timedisplay , parent , false)
        return mainscreenAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: mainscreenAdapter.ViewHolder, position: Int) {
        val time = mTime[position]

        holder.count.text = time.getCount().toString()
        holder.time.text = time.getTime().toString()

    }

    override fun getItemCount(): Int {
        return mTime.size
    }

    class ViewHolder (itemview: View) : RecyclerView.ViewHolder(itemview)
    {
        var count: TextView = itemview.findViewById(R.id.count)
        var time: TextView = itemview.findViewById(R.id.time)
    }

}