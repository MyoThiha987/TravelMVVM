package com.mth.padc.travelviper

import io.reactivex.Observable
import retrofit2.http.GET

interface ToursApi {

    @GET(GET_ALL_COUNTRIES)
    fun getAllCountries() : Observable<GetAllCountriesResponse>

    @GET(GET_ALL_TOURS)
    fun getAllTours() : Observable<GetAllToursResponse>
}