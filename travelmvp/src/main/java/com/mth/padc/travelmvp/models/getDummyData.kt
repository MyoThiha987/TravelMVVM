package com.mth.padc.travelmvp.models

import com.mth.padc.travelmvp.CountryVO
import com.mth.padc.travelmvp.ScoresAndReviewsVO

fun getDummyCountries() : List<CountryVO> {
    val country1 = CountryVO().apply {
        id = 1
        name = "Country 1"
        description = "Description 1"
        location = "Location 2"
        averagerating = 4.0
        photos = arrayListOf("", "")
        scoresandreviews = arrayListOf(ScoresAndReviewsVO())
    }

    val country2 = CountryVO().apply {
        id = 2
        name = "Country 2"
        description = "Description 2"
        location = "Location 2"
        averagerating = 2.0
        photos = arrayListOf("", "")
        scoresandreviews = arrayListOf(ScoresAndReviewsVO())
    }

    val country3 = CountryVO().apply {
        id = 3
        name = "Country 3"
        description = "Description 3"
        location = "Location 3"
        averagerating = 3.0
        photos = arrayListOf("", "")
        scoresandreviews = arrayListOf(ScoresAndReviewsVO())
    }
    return arrayListOf(country1, country2, country3)
}

fun getDummyTours() : List<CountryVO> {
    val tour1 = CountryVO().apply {
        id = 1
        name = "Tour 1"
    }

    val tour2 = CountryVO().apply {
        id = 2
        name = "Tour 2"
    }

    val tour3 = CountryVO().apply {
        id = 3
        name = "Tour 3"
    }
    return arrayListOf(tour1, tour2, tour3)
}

