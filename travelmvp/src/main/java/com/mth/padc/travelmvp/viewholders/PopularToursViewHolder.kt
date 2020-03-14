package com.mth.padc.travelmvp

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_popular_tours.view.*


class PopularToursViewHolder (itemView : View, private val delegate: ToursItemDelegate ) : BaseViewHolder<CountryVO>(itemView){
    override fun bindData(data: CountryVO) {
       mData = data
        itemView.tvCountryName.text = data.name
        itemView.tvRates.text = data.averagerating.toString()
        Glide.with(itemView.context)
            .load(data.photos[0])
            .into(itemView.ivCountryImage)

        itemView.setOnClickListener {
            mData?.let {
                delegate.TourItemClick(it.name)
            }
        }
    }



}