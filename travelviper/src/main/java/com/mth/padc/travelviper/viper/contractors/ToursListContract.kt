package com.mth.padc.travelviper.viper.contractors

import androidx.lifecycle.LiveData
import com.mth.padc.travelviper.CountryVO
import com.mth.padc.travelviper.ToursItemDelegate

interface ToursListContract{
    interface View{
        fun showTourList(toursLists:List<CountryVO>)
        fun showErrorMessage(message :String)
    }
    interface Presenter :ToursItemDelegate{
        fun onUIReady()
        fun onUIDestroy()
    }
    interface InterActor{
        fun getAllTorsLists(onError:(String)->Unit): LiveData<List<CountryVO>>
        fun syncToursListWithServer()
    }
    interface InterActorOutput{
        fun onToursListFetchSuccess(toursLists: List<CountryVO>)
        fun onToursListFetchFailure(errorMessage: String)
        fun onNewsListEmpty()
    }
}