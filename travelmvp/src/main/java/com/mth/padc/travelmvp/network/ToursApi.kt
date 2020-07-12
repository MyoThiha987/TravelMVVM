package com.mth.padc.travelmvp.network

import com.mth.padc.travelmvp.GetAllCountriesResponse
import com.mth.padc.travelmvp.GetAllToursResponse
import com.mth.padc.travelmvp.utility.GET_ALL_COUNTRIES
import com.mth.padc.travelmvp.utility.GET_ALL_TOURS
import io.reactivex.Observable
import retrofit2.http.GET

interface ToursApi {

    @GET(GET_ALL_COUNTRIES)
    fun getAllCountries() : Observable<GetAllCountriesResponse>

    @GET(GET_ALL_TOURS)
    fun getAllTours() : Observable<GetAllToursResponse>
}