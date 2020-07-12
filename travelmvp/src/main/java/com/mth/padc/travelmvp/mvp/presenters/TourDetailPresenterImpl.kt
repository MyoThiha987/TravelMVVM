package com.mth.padc.travelmvp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mth.padc.travelmvp.models.ToursModel
import com.mth.padc.travelmvp.models.ToursModelImpl
import com.mth.padc.travelmvp.mvp.views.TourDetailView

class TourDetailPresenterImpl : TourDetailPresenter,AbstractBasePresenter<TourDetailView>() {
     var mToursModel : ToursModel = ToursModelImpl

    override fun onUIReady(lifecycleOwner: LifecycleOwner,name :String) {
        mToursModel.getToursById(name).observe(lifecycleOwner, Observer {
            mView?.displayTourDetail(it)
        })

    }


}