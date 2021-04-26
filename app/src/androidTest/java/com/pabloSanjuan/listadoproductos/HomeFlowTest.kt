package com.pabloSanjuan.listadoproductos

//import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pabloSanjuan.listadoproductos.presentation.base.MainActivity
import com.pabloSanjuan.listadoproductos.presentation.home.HomeFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


@RunWith(PowerMockRunner::class)
@PrepareForTest(HomeFlowTest::class)
class HomeFlowTest {

    @Mock
    lateinit var homeFragment: HomeFragment
    private val query = "carro"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        homeFragment = Mockito.spy(HomeFragment())
    }
    @Test
    fun whenInputIsEmpty(){
        val result = homeFragment.getInputText()
        assert(result == "")
        Mockito.`when`(homeFragment.getInputText())
        assert(result == "")

    }

    @Test
    fun whenInputIsNotEmpty(){
        homeFragment.input_search.editText?.setText(query)
        val result = homeFragment.getInputText()
        assert(result == query)
    }
}