package com.mth.padc.travelmvvm


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mth.padc.travelmvvm.utility.snack
import com.mth.padc.travelmvvm.viewmodels.TravelListViewModel
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var mCountryAdapter : CountryAdapter
    private lateinit var mPopularToursAdapter: PopularToursAdapter
    private lateinit var mToursViewModel : TravelListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        setUpCountryRecycler()
        setPopularToursUpRecycler()
        setUpDataObserver(view)
    }

    private fun setUpViewModel(){
        mToursViewModel = ViewModelProviders.of(this).get(TravelListViewModel::class.java)
    }

    private fun setUpDataObserver(view: View){
        mToursViewModel.getToursData().observe(this, Observer {
            var aa=
            mCountryAdapter.setData(it.subList(0,4).toMutableList())
            mPopularToursAdapter.setData(it.subList(5,9).toMutableList())

        })

        mToursViewModel.getErrorLiveData().observe(this, Observer {
            view.snack(it,Snackbar.LENGTH_SHORT)
        })

        mToursViewModel.navigateToDetailActivity().observe(this, Observer {
            val tourDetails = FavouriteFragment.newInstance(it)
            fragmentManager!!.beginTransaction()
                .replace(R.id.frame,tourDetails)
                .addToBackStack(null)
                .commit()
        })
    }

    private fun setUpCountryRecycler(){
        mCountryAdapter = CountryAdapter(mToursViewModel)
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvCountry.layoutManager = layoutManager
        rvCountry.adapter = mCountryAdapter
    }

    private fun setPopularToursUpRecycler(){
        mPopularToursAdapter = PopularToursAdapter(mToursViewModel)
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvPopularTour.layoutManager = layoutManager
        rvPopularTour.adapter = mPopularToursAdapter
    }


}
