package com.mth.padc.travelmvp.mvp.views

import com.mth.padc.travelmvp.CountryVO

interface TourListsView : BaseView {
    fun showToursData(list : MutableList<CountryVO>)
    fun navigateToNewsDetails(name : String)
}