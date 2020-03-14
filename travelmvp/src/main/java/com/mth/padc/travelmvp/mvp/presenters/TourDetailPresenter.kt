package com.mth.padc.travelmvp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc.travelmvp.mvp.views.TourDetailView

interface TourDetailPresenter : BasePresenter<TourDetailView> {
    fun onUIReady(lifecycleOwner: LifecycleOwner,name : String)
}