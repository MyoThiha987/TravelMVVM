package com.mth.padc.travelmvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mth.padc.travelmvp.CountryVO
import com.mth.padc.travelmvp.models.ToursModel
import com.mth.padc.travelmvp.models.ToursModelImpl
import com.mth.padc.travelmvp.mvp.presenters.TourDetailPresenterImpl
import com.mth.padc.travelmvp.mvp.views.TourDetailView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailPresenterTest {

    private lateinit var mPresenter: TourDetailPresenterImpl

    @RelaxedMockK
    private lateinit var mView: TourDetailView

    private lateinit var mTravelModel: ToursModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)
        ToursModelImpl.init(ApplicationProvider.getApplicationContext())
        mPresenter = TourDetailPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mView = this.mView
    }



    @Test
    fun onUiReady_callCountryVo() {
        val lifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        val travelVo = CountryVO( name = "Hello")
        mPresenter.onUIReady(lifecycleOwner, travelVo.name)

        verify {
            mView.displayTourDetail(travelVo)
        }
    }
}