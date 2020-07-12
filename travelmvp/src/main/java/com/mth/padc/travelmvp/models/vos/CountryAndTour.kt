package com.mth.padc.travelmvp.models.vos

import com.mth.padc.travelmvp.CountryVO

data class CountryAndTour(
    var countryList :List<CountryVO>,
    var tourList : List<CountryVO>
)