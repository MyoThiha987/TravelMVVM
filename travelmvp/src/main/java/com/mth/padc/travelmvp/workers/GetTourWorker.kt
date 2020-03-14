package com.mth.padc.travelmvp

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.WorkerParameters

class GetTourWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {

    @SuppressLint("CheckResult")
    override fun doWork(): Result {
        var result = Result.failure()

        mToursModel.getAllTours(
        ).subscribe {
            result= Result.success()
        }
        return result
    }
}