package com.mth.padc.travelmvp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mth.padc.travelmvp.ToursModelImpl
import com.mth.padc.travelmvp.mvp.views.TourListsView

class TourListPresenterImpl : TourListPresenter,AbstractBasePresenter<TourListsView>(){
    private val mToursModel =ToursModelImpl

    override fun onUIReady(lifecyclcleowner: LifecycleOwner) {
       requestAllNews(lifecyclcleowner)

    }

    override fun TourItemClick(name: String) {
        mView?.navigateToNewsDetails(name)
    }

    private fun requestAllNews(lifecyclcleowner: LifecycleOwner){
        mToursModel.getDataFromDb{

        }.observe(lifecyclcleowner, Observer {
            mView?.showToursData(it.toMutableList())
        })
    }




}