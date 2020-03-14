package com.mth.padc.travelviper.viper.presenters

import androidx.lifecycle.Observer
import com.mth.padc.travelviper.CountryVO
import com.mth.padc.travelviper.HomeFragment
import com.mth.padc.travelviper.TourDetail
import com.mth.padc.travelviper.viper.contractors.ToursListContract
import ru.terrakok.cicerone.Router

class ToursListPresenter(
    var mView : ToursListContract.View?,
    var mInterActor : ToursListContract.InterActor?,
    var mRouter : Router?
): ToursListContract.Presenter,ToursListContract.InterActorOutput{
    override fun onUIReady() {
        mInterActor?.getAllTorsLists(onError = {
            onToursListFetchFailure(it)
        })?.observe(mView as HomeFragment, Observer {
            onToursListFetchSuccess(it)
        })

    }

    override fun onUIDestroy() {
        mView=null
        mInterActor=null
    }

    override fun TourItemClick(name: String)    {
        mRouter?.navigateTo(TourDetail.TAG,name)
    }

    override fun onToursListFetchSuccess(toursLists: List<CountryVO>) {
        mView?.showTourList(toursLists)
    }

    override fun onToursListFetchFailure(errorMessage: String) {
    }

    override fun onNewsListEmpty() {
    }

}