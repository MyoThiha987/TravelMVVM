package com.mth.padc.travelmvp.root

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.mth.padc.travelmvp.workers.GetTourWorker
import com.mth.padc.travelmvp.models.ToursModelImpl

class ToursApp : Application(){

    override fun onCreate() {
        super.onCreate()
        ToursModelImpl.init(applicationContext)
        getToursDataOneTime()
    }

    private fun getToursDataOneTime(){
        val getEventsWorkerRequest = OneTimeWorkRequest
            .Builder(GetTourWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(getEventsWorkerRequest)

    }

}