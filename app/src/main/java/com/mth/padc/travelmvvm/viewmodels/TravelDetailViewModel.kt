package com.mth.padc.travelmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mth.padc.travelmvvm.CountryVO
import com.mth.padc.travelmvvm.ToursModel
import com.mth.padc.travelmvvm.ToursModelImpl

class TravelDetailViewModel : ViewModel() {
    private val mToursModel: ToursModel = ToursModelImpl

    fun getTourDetails(name : String) : LiveData<CountryVO>{
        return mToursModel.getToursById(name)
    }
}