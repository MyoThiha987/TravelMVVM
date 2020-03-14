package com.mth.padc.travelmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mth.padc.travelmvvm.CountryVO
import com.mth.padc.travelmvvm.ToursItemDelegate
import com.mth.padc.travelmvvm.ToursModelImpl

class TravelListViewModel : ViewModel(), ToursItemDelegate {

    private val mToursModel : ToursModelImpl = ToursModelImpl
    private val errorLiveData : MutableLiveData<String> = MutableLiveData()
    private val navigateToDetailLiveData : MutableLiveData<String> = MutableLiveData()
    private val mToursList : LiveData<List<CountryVO>> = mToursModel.getDataFromDb{
        errorLiveData.postValue(it)
    }

    fun getToursData():LiveData<List<CountryVO>>{
        return mToursList
    }

    fun getErrorLiveData(): LiveData<String>{
        return errorLiveData
    }

    fun navigateToDetailActivity() : LiveData<String>{
        return navigateToDetailLiveData
    }

    override fun TourItemClick(name: String) {
        navigateToDetailLiveData.postValue(name)

    }
}