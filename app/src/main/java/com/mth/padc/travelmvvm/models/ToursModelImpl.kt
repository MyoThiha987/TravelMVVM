package com.mth.padc.travelmvvm

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers


object ToursModelImpl : ToursModel, BaseModel() {

   private val countries = mToursApi.getAllCountries().map { it.data }
   private val tours = mToursApi.getAllTours().map { it.data }


    @SuppressLint("CheckResult")
    override fun getAllTours() : Observable<CountriesAndCountryVO>{
        return Observable.zip<List<CountryVO>, List<CountryVO>, CountriesAndCountryVO>(
            countries, tours,
            BiFunction { t1, t2 ->
                t1.forEach {
                    Log.d("Tours", it.toString())
                }
                return@BiFunction CountriesAndCountryVO(t1,t2)
            }

        ).doOnNext {

                val countriesAndToursList = arrayListOf(it.country, it.tours)
                    .flatten()
                mDataBase.dao().deleteAllData()
                mDataBase.dao().saveAllTourData(countriesAndToursList.toMutableList())
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

    override fun getDataFromDb(onError : (String)->Unit): LiveData<List<CountryVO>> {
        return mDataBase.dao().getAllData()
    }

    override fun getToursById(name : String): LiveData<CountryVO> {
       return mDataBase.dao().getToursData(name)

    }
}