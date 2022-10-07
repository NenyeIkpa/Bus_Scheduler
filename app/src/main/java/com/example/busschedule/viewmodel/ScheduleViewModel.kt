package com.example.busschedule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalArgumentException

class ScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {

    fun fullSchedule(): Flow<List<Schedule>> = scheduleDao.getAll()

    fun scheduleForStopName(stopName: String): Flow<List<Schedule>> = scheduleDao.getByStopName(stopName)
}


/**
 * As the ViewModel class ScheduleViewModel is meant to be lifecycle aware,
 * it should be instantiated by an object that can respond to lifecycle events.
 * If it is directly instantiated in a fragment, then the fragment object will have to handle everything,
 * including all the memory management, which is beyond the scope of what an app's code should do.
 * Instead, a class called a factory can be created, that will instantiate the view model objects.
 */

class ScheduleViewModelFactory(private val scheduleDao: ScheduleDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}