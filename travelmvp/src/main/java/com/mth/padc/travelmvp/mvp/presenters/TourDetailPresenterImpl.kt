package com.mth.padc.travelmvp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mth.padc.travelmvp.ToursModelImpl
import com.mth.padc.travelmvp.mvp.views.TourDetailView

class TourDetailPresenterImpl : TourDetailPresenter,AbstractBasePresenter<TourDetailView>() {
    private val mToursModel = ToursModelImpl

    override fun onUIReady(lifecycleOwner: LifecycleOwner,name :String) {
        mToursModel.getToursById(name).observe(lifecycleOwner, Observer {
            mView?.displayTourDetail(it)
        })

    }


}