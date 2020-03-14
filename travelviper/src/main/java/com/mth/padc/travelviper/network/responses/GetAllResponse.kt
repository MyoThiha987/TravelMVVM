package com.mth.padc.travelviper

import com.google.gson.annotations.SerializedName

data class GetAllCountriesResponse(
    @SerializedName("code")
    val code : Int = 0,
    @SerializedName("message")
    val message : String = "",
    @SerializedName("data")
    val data : List<CountryVO>
)

data class GetAllToursResponse(
    @SerializedName("code")
    val code : Int = 0,
    @SerializedName("message")
    val message : String = "",
    @SerializedName("data")
    val data : List<CountryVO>
)