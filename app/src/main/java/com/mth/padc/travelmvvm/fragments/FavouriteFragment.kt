package com.mth.padc.travelmvvm


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.list.rados.fast_list.bind
import com.mth.padc.travelmvvm.viewmodels.TravelDetailViewModel
import kotlinx.android.synthetic.main.fragment_favourit.view.*
import kotlinx.android.synthetic.main.list_item_tours_photos.*
import kotlinx.android.synthetic.main.list_item_tours_photos.view.*

import java.util.stream.Collectors.toList

/**
 * A simple [Fragment] subclass.
 */
class FavouriteFragment : Fragment() {
private lateinit var mTourDetailViewModel : TravelDetailViewModel

    companion object {
        fun newInstance(name: String): FavouriteFragment {
            val args = Bundle()
            args.putString("nn", name)
            val fragment = FavouriteFragment()
            fragment.arguments = args
            return fragment

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favourit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        setUpDataObserver(view)

//        mToursModel.getToursById(arguments?.getString("nn") ?: "").observe(this,
//            Observer {
//                it?.let {
//                    bidData(it, view)
//                }
//            })


    }

    private fun setUpViewModel(){
        mTourDetailViewModel= ViewModelProviders.of(this).get(TravelDetailViewModel::class.java)
    }

    private fun setUpDataObserver(view: View){
        mTourDetailViewModel.getTourDetails(arguments?.getString("nn") ?: "").observe(this, Observer {
            it.let {
                bidData(it,view)
            }
        })
    }

    private fun bidData(data: CountryVO, view: View) {
        Glide.with(context!!)
            .load(data.photos[0])
            .into(view.ivImageDetail)
        view.tvResortName.text = data.name
        view.tvLocation.text = data.location
        view.tvRating.text = data.averagerating.toString()
        view.ratingBar.rating = data.averagerating.toFloat()
        view.tvDetails.text = data.description
        view.tvBooking.text = data.scoresandreviews[0].name
        view.tvScore.text =
            "${data.scoresandreviews[0].score} /${data.scoresandreviews[0].max_score}"
        view.tvReview.text = "Based on ${data.scoresandreviews[0].total_reviews} reviews"
        view.tvHotelOut.text = data?.scoresandreviews[1].name
        view.tvHotelOutScore.text =
            "${data.scoresandreviews[1].score} /${data.scoresandreviews[0].max_score}"
        view.tvHotelOutReview.text = "Based on ${data.scoresandreviews[1].total_reviews} reviews"
        view.rvPhotos.bind(data.photos.toList(), R.layout.list_item_tours_photos) {
            Glide.with(context)
                .load(it)
                .into(ivPhotoCollections)

            }
            .layoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))

    }
}
