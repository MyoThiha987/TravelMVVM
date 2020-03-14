package com.mth.padc.travelmvp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mth.padc.travelmvp.mvp.presenters.TourListPresenter
import com.mth.padc.travelmvp.mvp.presenters.TourListPresenterImpl
import com.mth.padc.travelmvp.mvp.views.TourListsView
import com.mth.padc.travelmvp.utility.snack
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), TourListsView {

    private lateinit var mCountryAdapter : CountryAdapter
    private lateinit var mPopularToursAdapter: PopularToursAdapter
    private lateinit var mPresenter : TourListPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        mPresenter.onUIReady(this)
        setUpCountryRecycler()
        setPopularToursUpRecycler()
        //setUpDataObserver(view)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(TourListPresenterImpl::class.java)
            mPresenter.initPresenter(this)
    }

    override fun showToursData(list: MutableList<CountryVO>) {
        mCountryAdapter.setData(list.subList(0,4).toMutableList())
        mPopularToursAdapter.setData(list.subList(5,9).toMutableList())
    }

    override fun navigateToNewsDetails(name: String) {
        val tourDetails = FavouriteFragment.newInstance(name)
            fragmentManager!!.beginTransaction()
                .replace(R.id.frame,tourDetails)
                .addToBackStack(null)
                .commit()
    }

    private fun setUpCountryRecycler(){

         mCountryAdapter = CountryAdapter(mPresenter)
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvCountry.layoutManager = layoutManager
        rvCountry.adapter = mCountryAdapter
    }

    private fun setPopularToursUpRecycler(){
        mPopularToursAdapter = PopularToursAdapter(mPresenter)
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvPopularTour.layoutManager = layoutManager
        rvPopularTour.adapter = mPopularToursAdapter
    }



}
