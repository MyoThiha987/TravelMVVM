package com.mth.padc.travelmvp.mvp.views

import com.mth.padc.travelmvp.CountryVO

interface TourDetailView : BaseView {
    fun displayTourDetail(countryVO: CountryVO)
}