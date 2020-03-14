package com.mth.padc.travelmvvm

import android.app.Application
import android.content.Context
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class ToursApp : Application(){

    override fun onCreate() {
        super.onCreate()
        ToursModelImpl.initDataBase(applicationContext)
        getToursDataOneTime()
    }

   private fun getToursDataOneTime(){
        val getEventsWorkerRequest = OneTimeWorkRequest
            .Builder(GetTourWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(getEventsWorkerRequest)

    }

}