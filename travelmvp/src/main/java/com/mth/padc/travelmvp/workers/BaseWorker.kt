package com.mth.padc.travelmvp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mth.padc.travelmvp.models.ToursModelImpl
import com.mth.padc.travelmvp.models.ToursModel

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val mToursModel : ToursModel = ToursModelImpl
}