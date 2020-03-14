package com.mth.padc.travelviper

import androidx.lifecycle.LiveData
import io.reactivex.Observable

interface ToursModel  {

    fun getAllTours(): Observable<CountriesAndCountryVO>

    fun getDataFromDb(onError : (String)->Unit) : LiveData<List<CountryVO>>

    fun getToursById(name : String) : LiveData<CountryVO>







}