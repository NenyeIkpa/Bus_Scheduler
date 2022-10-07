package com.example.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao

/**
 * An Android app using Room, subclasses the RoomDatabase class. the app's database needs to:
 * 1. Specify which entities are defined in the database.
 * 2. Provide access to a single instance of each DAO class.
 * 3. Perform any additional setup, such as pre-populating the database.
 *
 * The AppDatabase(app's database) class gives you complete control over your models,
 * DAO classes, and any database setup you wish to perform.
 */

@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao


    /**
     * When using an AppDatabase class, you want to ensure that only one instance of the database exists
     * to prevent race conditions or other potential issues. The instance is stored in the companion object,
     * and you'll also need a method that either returns the existing instance,
     * or creates the database for the first time.This is defined in the companion object.
     */

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return (INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            })
        }
    }

}