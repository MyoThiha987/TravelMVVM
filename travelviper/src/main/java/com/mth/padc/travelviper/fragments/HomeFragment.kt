package com.mth.padc.travelviper


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mth.padc.travelviper.utility.snack
import com.mth.padc.travelviper.viper.contractors.ToursListContract
import com.mth.padc.travelviper.viper.interactors.ToursListInteractor
import com.mth.padc.travelviper.viper.presenters.ToursListPresenter
import kotlinx.android.synthetic.main.fragment_home.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), ToursListContract.View {

    private lateinit var mCountryAdapter : CountryAdapter
    private lateinit var mPopularToursAdapter: PopularToursAdapter
    private lateinit var mPresenter : ToursListPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpNavigator()
        setUpPresenter()
        mPresenter.onUIReady()

        setUpCountryRecycler()
        setPopularToursUpRecycler()
    }

    private val navigator: Navigator? by lazy {
        object : Navigator {
            override fun applyCommand(command: Command?) {
                if (command is Forward) {
                    forward(command)
                }
            }

            private fun forward(command: Forward) {
                val name = command.transitionData as String
                when (command.screenKey) {
                    TourDetail.TAG -> {
                        startActivity(TourDetail.newIntent(context!!,name))
                    }
                }
            }
        }

    }

    private val router: Router? by lazy {
        ToursApp.INSTANCE.cicerone.router
    }

    private fun setUpNavigator() {
        ToursApp.INSTANCE.cicerone.navigatorHolder.setNavigator(navigator)
    }

    private fun setUpPresenter(){
        mPresenter = ToursListPresenter(this,ToursListInteractor(),router!!)

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

    override fun showTourList(toursLists: List<CountryVO>) {
        mCountryAdapter.setData(toursLists.subList(0,4).toMutableList())
        mPopularToursAdapter.setData(toursLists.subList(5,9).toMutableList())
    }

    override fun showErrorMessage(message: String) {
        view!!.snack(message,Snackbar.LENGTH_SHORT)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onUIDestroy()
    }
}
