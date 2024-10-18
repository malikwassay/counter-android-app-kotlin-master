package com.example.counterapp.Model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime

class Time {

    private var count: Int = 0
    @RequiresApi(Build.VERSION_CODES.O)
    private var time: LocalTime = LocalTime.now()

    constructor()

    @RequiresApi(Build.VERSION_CODES.O)
    constructor(count: Int, time:LocalTime)
    {
        this.count = count
        this.time = time
    }

    fun getCount(): Int
    {
        return count
    }

    fun setCount(count: Int)
    {
        this.count = count
    }

    fun setTime(time: LocalTime)
    {
        this.time = time
    }


    fun getTime(): LocalTime
    {
        return time
    }

}