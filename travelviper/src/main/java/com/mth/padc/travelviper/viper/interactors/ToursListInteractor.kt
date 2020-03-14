package com.mth.padc.travelviper.viper.interactors

import androidx.lifecycle.LiveData
import com.mth.padc.travelviper.CountryVO
import com.mth.padc.travelviper.ToursModel
import com.mth.padc.travelviper.ToursModelImpl
import com.mth.padc.travelviper.viper.contractors.ToursListContract

class ToursListInteractor :ToursListContract.InterActor{
    private val mTourModel: ToursModel = ToursModelImpl

    override fun getAllTorsLists(onError:(String)->Unit): LiveData<List<CountryVO>> {
    return mTourModel.getDataFromDb(onError)

    }
    override fun syncToursListWithServer() {
    mTourModel.getAllTours()
    }

}