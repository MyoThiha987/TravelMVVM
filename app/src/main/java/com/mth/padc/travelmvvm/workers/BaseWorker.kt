package com.mth.padc.travelmvvm

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val mToursModel : ToursModel = ToursModelImpl
}