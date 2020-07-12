package com.mth.padc.travelmvp.models

import androidx.lifecycle.LiveData
import com.mth.padc.travelmvp.CountriesAndCountryVO
import com.mth.padc.travelmvp.CountryVO
import io.reactivex.Observable

interface ToursModel  {

    fun getAllTours(): Observable<CountriesAndCountryVO>

    fun getDataFromDb(onError : (String)->Unit) : LiveData<List<CountryVO>>

    fun getToursById(name : String) : LiveData<CountryVO>







}