package com.example.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


/**
 * The DAO is where you would include functions for reading and manipulating data.
 * Calling a function on the DAO is the equivalent of performing a SQL command on the database.
 */

@Dao
interface ScheduleDao {

    /**
     * Queries are specified as strings passed into a @Query annotation
     */

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): Flow<List<Schedule>>


    /**
     * You can reference Kotlin values from the query by preceding it with a colon (:)
     * (e.g. :stopName from the function parameter
     */
    @Query("SELECT * FROM schedule where stop_name= :stopName ORDER BY arrival_time ASC")
    fun getByStopName(stopName: String): Flow<List<Schedule>>
}