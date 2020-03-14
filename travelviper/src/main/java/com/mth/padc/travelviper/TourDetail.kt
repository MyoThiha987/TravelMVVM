package com.mth.padc.travelviper

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.list.rados.fast_list.bind
import com.mth.padc.travelviper.viper.contractors.TourDetailContract
import com.mth.padc.travelviper.viper.interactors.TourDetailInteractor
import com.mth.padc.travelviper.viper.presenters.TourDetailPresenter
import kotlinx.android.synthetic.main.activity_tour_detail.*
import kotlinx.android.synthetic.main.list_item_tours_photos.view.*
import ru.terrakok.cicerone.Router

class TourDetail : AppCompatActivity(),TourDetailContract.View {
    companion object {
        const val TAG = "ToursDetail"

        private const val TOURS_NAME_EXTRA = "News Id Extra"

        fun newIntent(context: Context, name: String): Intent {
            val intent = Intent(context, TourDetail::class.java)
            intent.putExtra("TOURS_NAME_EXTRA",name)
            return intent
        }
    }
    private lateinit var mTourDetailPresenter : TourDetailPresenter

    private val router: Router? by lazy {
        ToursApp.INSTANCE.cicerone.router
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour_detail)
        val name = intent.getStringExtra("TOURS_NAME_EXTRA")
        initPresenter()
        mTourDetailPresenter.onUIReady(name)
    }

    override fun onDestroy() {
        super.onDestroy()
        mTourDetailPresenter.onUIDestroy()
    }

    private fun initPresenter(){
        mTourDetailPresenter = TourDetailPresenter(this, TourDetailInteractor(),router!!)
    }

    private fun bidData(data: CountryVO) {
        Glide.with(this)
            .load(data.photos[0])
            .into(ivImageDetail)
        tvResortName.text = data.name
        tvLocation.text = data.location
        tvRating.text = data.averagerating.toString()
        ratingBar.rating = data.averagerating.toFloat()
        tvDetails.text = data.description
        tvBooking.text = data.scoresandreviews[0].name
        tvScore.text =
            "${data.scoresandreviews[0].score} /${data.scoresandreviews[0].max_score}"
        tvReview.text = "Based on ${data.scoresandreviews[0].total_reviews} reviews"
        tvHotelOut.text = data.scoresandreviews[1].name
        tvHotelOutScore.text =
            "${data.scoresandreviews[1].score} /${data.scoresandreviews[0].max_score}"
        tvHotelOutReview.text = "Based on ${data.scoresandreviews[1].total_reviews} reviews"
        rvPhotos.bind(data.photos.toList(), R.layout.list_item_tours_photos) {
                Glide.with(context)
                    .load(it)
                    .into(ivPhotoCollections)


            }
            .layoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))

    }
    override fun showTourDetail(countryVO: CountryVO) {
        bidData(countryVO)
    }
}
