package com.mth.padc.travelviper


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.list.rados.fast_list.bind
import com.mth.padc.travelviper.viper.contractors.TourDetailContract
import com.mth.padc.travelviper.viper.interactors.TourDetailInteractor
import com.mth.padc.travelviper.viper.presenters.TourDetailPresenter
import kotlinx.android.synthetic.main.fragment_favourit.view.*
import kotlinx.android.synthetic.main.list_item_tours_photos.view.*
import ru.terrakok.cicerone.Router

/**
 * A simple [Fragment] subclass.
 */
class FavouriteFragment : Fragment() {


//    companion object {
//        val TAG: Any
//            get() {
//                TODO()
//            }
//
//        fun newInstance(name: String): FavouriteFragment {
//            val args = Bundle()
//            args.putString("nn", name)
//            val fragment = FavouriteFragment()
//            fragment.arguments = args
//            return fragment
//
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        return inflater.inflate(R.layout.fragment_favourit, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initPresenter()
//        mTourDetailPresenter.onUIReady(arguments!!.getString("nn")?:"")
//
//    }
//    private val router: Router? by lazy {
//        ToursApp.INSTANCE.cicerone.router
//    }
//
//    private fun initPresenter(){
//        mTourDetailPresenter = TourDetailPresenter(this,TourDetailInteractor(),router!!)
//    }
//
//    private fun bidData(data: CountryVO, view: View) {
//        Glide.with(context!!)
//            .load(data.photos[0])
//            .into(view.ivImageDetail)
//        view.tvResortName.text = data.name
//        view.tvLocation.text = data.location
//        view.tvRating.text = data.averagerating.toString()
//        view.ratingBar.rating = data.averagerating.toFloat()
//        view.tvDetails.text = data.description
//        view.tvBooking.text = data.scoresandreviews[0].name
//        view.tvScore.text =
//            "${data.scoresandreviews[0].score} /${data.scoresandreviews[0].max_score}"
//        view.tvReview.text = "Based on ${data.scoresandreviews[0].total_reviews} reviews"
//        view.tvHotelOut.text = data.scoresandreviews[1].name
//        view.tvHotelOutScore.text =
//            "${data.scoresandreviews[1].score} /${data.scoresandreviews[0].max_score}"
//        view.tvHotelOutReview.text = "Based on ${data.scoresandreviews[1].total_reviews} reviews"
//        view.rvPhotos.bind(data.photos.toList(), R.layout.list_item_tours_photos) {
//            Glide.with(context)
//                .load(it)
//                .into(ivPhotoCollections)
//
//
//        }
//            .layoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
//
//    }
//
//    override fun showTourDetail(countryVO: CountryVO) {
//        view?.let { bidData(countryVO, it) }    }
}
