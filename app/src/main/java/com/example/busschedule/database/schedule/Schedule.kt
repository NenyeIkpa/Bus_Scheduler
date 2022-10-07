package com.example.busschedule.database.schedule

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * By default, Room uses the class name as the database table name.
 * Thus, the table name as defined by the class right now would be Schedule.
 * Optionally, you could also specify @Entity(tableName="schedule"),
 * but since Room queries are not case sensitive, you can omit explicitly defining a lowercase table name here.
 */

@Entity(tableName = "schedule")
data class Schedule(
   @PrimaryKey val id: Int,
   @NonNull @ColumnInfo(name = "stop_name")val stopName: String,
   @NonNull @ColumnInfo(name = "arrival_time")val arrivalTime: Int
)
