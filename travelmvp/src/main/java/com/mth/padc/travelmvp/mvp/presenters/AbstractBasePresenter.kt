package com.mth.padc.travelmvp.mvp.presenters

import androidx.lifecycle.ViewModel
import com.mth.padc.travelmvp.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>: BasePresenter<T> ,ViewModel(){
    var mView : T?=null
    override fun initPresenter(view:T) {
        mView=view
    }

}