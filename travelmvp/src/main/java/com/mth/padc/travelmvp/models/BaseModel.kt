package com.mth.padc.travelmvp.models

import android.content.Context
import com.mth.padc.travelmvp.AppDatabase
import com.mth.padc.travelmvp.network.ToursApi
import com.mth.padc.travelmvp.utility.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


abstract class BaseModel {
   protected var mToursApi : ToursApi
    protected lateinit var mDataBase : AppDatabase

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mToursApi = retrofit.create(ToursApi::class.java)
    }

    fun init(context: Context){
        initDataBase(context)
    }

    fun initDataBase(context: Context){
        mDataBase= AppDatabase.getDatabase(context)
    }

    }