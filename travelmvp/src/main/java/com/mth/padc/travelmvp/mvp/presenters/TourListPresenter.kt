package com.mth.padc.travelmvp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc.travelmvp.ToursItemDelegate
import com.mth.padc.travelmvp.mvp.views.TourListsView

interface TourListPresenter : ToursItemDelegate,BasePresenter<TourListsView>{
    fun onUIReady(lifecyclcleowner:LifecycleOwner)
}