package com.mth.padc.travelviper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc.travelviper.viper.presenters.ToursListPresenter

class CountryAdapter(val delegate: ToursItemDelegate) : BaseAdapter<BaseViewHolder<CountryVO>,CountryVO>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_country,parent,false)
        return CountryViewHolder(view,delegate)
    }

}