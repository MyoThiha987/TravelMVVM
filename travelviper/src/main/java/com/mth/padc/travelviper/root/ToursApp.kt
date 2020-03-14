package com.mth.padc.travelviper

import android.app.Application
import android.content.Context
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class ToursApp : Application(){

    companion object {
        lateinit var INSTANCE: ToursApp
    }

    init {
        INSTANCE = this
    }

    lateinit var cicerone: Cicerone<Router>

    override fun onCreate() {
        super.onCreate()
        initCicerone()
        ToursModelImpl.initDataBase(applicationContext)
        getToursDataOneTime()
    }

    private fun initCicerone(){
        this.cicerone = Cicerone.create()
    }

    private fun getToursDataOneTime(){
        val getEventsWorkerRequest = OneTimeWorkRequest
            .Builder(GetTourWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(getEventsWorkerRequest)

    }

}