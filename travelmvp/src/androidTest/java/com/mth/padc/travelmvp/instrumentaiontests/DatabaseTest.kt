package com.mth.padc.travelmvp.instrumentaiontests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mth.padc.travelmvp.AppDatabase
import com.mth.padc.travelmvp.CountryDao
import com.mth.padc.travelmvp.CountryVO
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DataBaseTest {
    private lateinit var TourDao : CountryDao
    private lateinit var db : AppDatabase

    @Before
    fun setUpDB(){
        val context= ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java).build()
        TourDao=db.dao()
    }

    @After
    fun closeDB(){
        db.close()
    }

    @Test
    fun databaseTest() {
        val countryVo = CountryVO()
        countryVo.name = "Myanmar"

        TourDao.saveData(countryVo)
        assert(TourDao.getToursData(countryVo.name).value?.name == countryVo.name)
    }
}