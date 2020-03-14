package com.mth.padc.travelviper.viper.interactors

import androidx.lifecycle.LiveData
import com.mth.padc.travelviper.CountryVO
import com.mth.padc.travelviper.ToursModel
import com.mth.padc.travelviper.ToursModelImpl
import com.mth.padc.travelviper.viper.contractors.TourDetailContract

class TourDetailInteractor :TourDetailContract.InterActor{
    private val mTourModel:ToursModel=ToursModelImpl
    override fun getTourDetails(name:String): LiveData<CountryVO> {
        return mTourModel.getToursById(name)
    }


}