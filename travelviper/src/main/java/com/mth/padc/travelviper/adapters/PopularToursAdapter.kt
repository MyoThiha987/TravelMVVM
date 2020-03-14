package com.mth.padc.travelviper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc.travelviper.viper.presenters.ToursListPresenter


class PopularToursAdapter(val delegate: ToursItemDelegate) : BaseAdapter<BaseViewHolder<CountryVO>,CountryVO>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_popular_tours,parent,false)
        return PopularToursViewHolder(view,delegate)
    }

}