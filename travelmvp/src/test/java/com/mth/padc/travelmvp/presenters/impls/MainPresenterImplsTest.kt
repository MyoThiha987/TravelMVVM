package com.mth.padc.travelmvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mth.padc.travelmvp.CountryVO
import com.mth.padc.travelmvp.models.*
import com.mth.padc.travelmvp.mvp.presenters.TourListPresenterImpl
import com.mth.padc.travelmvp.mvp.views.TourListsView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplsTest {

    private lateinit var mPresenter : TourListPresenterImpl

    @RelaxedMockK
    private lateinit var mView : TourListsView

    private lateinit var mModel : ToursModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)
        ToursModelImpl.init(ApplicationProvider.getApplicationContext())
        mModel = MockTourModelImpl
        mPresenter = TourListPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mView = this.mView
    }

    @Test
    fun onUiReady_callGetAllCountriesAndTours() {
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)
        mPresenter.onUIReady(lifecycleOwner)
        verify {
            mView.showToursData(getDummyCountries().toMutableList())
        }
    }

    @Test
    fun onTapList_callToCountryDetail(){
        val tourVo = CountryVO()
        tourVo.name ="Myanmar"
        mPresenter.TourItemClick(tourVo.name)
        verify {
            mView.navigateToNewsDetails(tourVo.name)
        }
    }
}