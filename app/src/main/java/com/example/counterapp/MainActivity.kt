package com.example.counterapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.counterapp.Model.Time
import com.example.counterapp.adapter.mainscreenAdapter
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    private var mTime: MutableList<Time>? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()


        val text = findViewById<TextView>(R.id.text_view)
        val addButton = findViewById<Button>(R.id.add_button)
        val resetButton = findViewById<Button>(R.id.reset_button)
        val saveButton = findViewById<Button>(R.id.save_button)
        val recycler = findViewById<RecyclerView>(R.id.time_recycler)
        val totalcounter = findViewById<TextView>(R.id.total_counter)


        mTime = ArrayList()

        val timeadapter = mainscreenAdapter(baseContext , mTime as ArrayList<Time>)

        var count = 0
        var totalcount = 0

        recycler.adapter = timeadapter
        recycler.layoutManager = LinearLayoutManager(baseContext)

        text.text = count.toString()
        totalcounter.text = "0"

        addButton.setOnClickListener{
            count++
            text.text = count.toString()
        }

        resetButton.setOnClickListener{
            count = 0
            text.text = count.toString()
            mTime?.clear()
            timeadapter?.notifyDataSetChanged()
            totalcount = 0
            totalcounter.text = totalcount.toString()
        }


        saveButton.setOnClickListener {
            if (count != 0) {
                var newval: Time = Time(count, LocalTime.now())
                mTime?.add(newval)
                timeadapter?.notifyDataSetChanged()
                totalcount += count
                totalcounter.text = totalcount.toString()
                count = 0
                text.text = count.toString()

            }
        }


    }
}
