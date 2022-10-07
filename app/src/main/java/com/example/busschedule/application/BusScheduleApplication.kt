package com.example.busschedule.application

import android.app.Application
import androidx.room.Room
import com.example.busschedule.database.AppDatabase

class BusScheduleApplication: Application() {
  val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}