package com.mth.padc.travelviper.viper.contractors

import androidx.lifecycle.LiveData
import com.mth.padc.travelviper.CountryVO

interface TourDetailContract{
    interface View{
        fun showTourDetail(countryVO: CountryVO)
    }
    interface Presenter{
        fun onUIReady(name:String)
        fun onUIDestroy()
    }
    interface InterActor{
        fun getTourDetails(name: String):LiveData<CountryVO>
    }
    interface InterActorOutput{
        fun onToursListFetchSuccess(tourVO: CountryVO)

    }
}