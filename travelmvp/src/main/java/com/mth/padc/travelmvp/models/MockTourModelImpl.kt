package com.mth.padc.travelmvp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mth.padc.travelmvp.CountriesAndCountryVO
import com.mth.padc.travelmvp.CountryVO
import com.mth.padc.travelmvp.models.vos.CountryAndTour
import io.reactivex.Observable


object MockTourModelImpl : ToursModel{

    override fun getAllTours(): Observable<CountriesAndCountryVO> {
        return Observable.just((CountryAndTour(getDummyCountries(), getDummyTours())) as CountriesAndCountryVO)
    }

    override fun getDataFromDb(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        val liveData = MutableLiveData<List<CountryVO>>()
        liveData.postValue(getDummyCountries())
        return liveData
    }

    override fun getToursById(name: String): LiveData<CountryVO> {
        val liveData = MutableLiveData<CountryVO>()
        liveData.postValue(CountryVO(name = "Hello"))
        return liveData

    }


}