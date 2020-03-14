package com.mth.padc.travelmvvm

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllTourData(list: MutableList<CountryVO>): LongArray

    @Query("select * from country where name = :name ")
    fun getToursData(name: String): LiveData<CountryVO>

    @Query("select * from country")
    fun getAllData(): LiveData<List<CountryVO>>

    @Query("delete from country")
    fun deleteAllData()




}