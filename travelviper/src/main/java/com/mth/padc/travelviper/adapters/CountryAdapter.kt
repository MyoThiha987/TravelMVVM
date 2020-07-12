package com.mth.padc.travelviper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc.travelviper.viper.presenters.ToursListPresenter

class CountryAdapter(val delegate: ToursItemDelegate) : BaseAdapter<BaseViewHolder<CountryVO>,CountryVO>(){
    val countryVH =2424
    val tourVH =2425



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        when(viewType){
            countryVH->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_country,parent,false)
                return CountryViewHolder(view,delegate)
            }
            tourVH->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_popular_tours,parent,false)
                return PopularToursViewHolder(view,delegate)
            }
            else->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_country,parent,false)
                return CountryViewHolder(view,delegate)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
         when{
             position ==0->{
                 return countryVH
             }
             else->{
                 return tourVH

            }

        }
    }

}