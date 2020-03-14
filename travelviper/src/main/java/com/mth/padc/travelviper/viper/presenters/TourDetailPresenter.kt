package com.mth.padc.travelviper.viper.presenters

import androidx.lifecycle.Observer
import com.mth.padc.travelviper.CountryVO
import com.mth.padc.travelviper.TourDetail
import com.mth.padc.travelviper.viper.contractors.TourDetailContract
import ru.terrakok.cicerone.Router

class TourDetailPresenter (
    var mView:TourDetailContract.View?,
    var mInterActor : TourDetailContract.InterActor?,
    var mRouter : Router?
): TourDetailContract.Presenter,TourDetailContract.InterActorOutput{
    override fun onUIReady(name: String) {
        mInterActor?.getTourDetails(name)?.observe(mView as TourDetail, Observer {
            onToursListFetchSuccess(it)
        })
    }

    override fun onUIDestroy() {
        mView=null
        mInterActor=null
    }

    override fun onToursListFetchSuccess(tourVO: CountryVO) {
        mView?.showTourDetail(tourVO)
    }

}