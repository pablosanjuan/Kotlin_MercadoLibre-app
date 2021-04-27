package com.pabloSanjuan.listadoproductos

import android.app.Activity
import androidx.test.platform.app.InstrumentationRegistry
import com.pabloSanjuan.listadoproductos.domain.repositories.SearchRepository
import com.pabloSanjuan.listadoproductos.domain.usescases.SearchUseCase
import com.pabloSanjuan.listadoproductos.presentation.home.HomeFragment
import com.pabloSanjuan.listadoproductos.presentation.home.HomeViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
//import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Config(manifest = "app/src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner::class)
class CoroutineScopeTest {


    lateinit var vm: HomeViewModel

    @Mock
    lateinit var repository: SearchRepository
    @Mock
    lateinit var searchUseCase: SearchUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        vm = Mockito.spy(HomeViewModel(searchUseCase))
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.pabloSanjuan.listadoproductos", appContext.packageName)
    }

    @Test
    fun apiResponse() = runBlocking {
        val params = HashMap<String, String>()
        params["q"] = "moto"
        val repoImpl = repository.getSearchData(params)
        Mockito.verify(repoImpl.isSuccessful)
        assertEquals(repoImpl.isSuccessful, Any())

    }
}