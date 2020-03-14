package com.mth.padc.travelmvp.mvp.presenters

import com.mth.padc.travelmvp.mvp.views.BaseView

interface BasePresenter<T:BaseView> {
    fun initPresenter(view : T)

}