package home
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.shop.commons.ShopAnalytics
import br.com.shop.commons.ShopCache
import br.com.shop.home.HomeCallback
import br.com.shop.home.repository.HomeResponse
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import br.com.shop.home.viewmodel.HomeViewModel
import br.com.shop.home.viewmodel.HomeViewState
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK

@ExtendWith(CoroutineTestExtension::class)
class HomeViewModelTest {

    @Rule @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var homeCallback: HomeCallback

    @RelaxedMockK
    private lateinit var shopAnalytics: ShopAnalytics

    private lateinit var viewModel: HomeViewModel


    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())

        MockKAnnotations.init(this)
        viewModel = HomeViewModel(homeCallback, shopAnalytics)
    }

    @AfterEach
    fun afterEach() {
        Dispatchers.resetMain()
    }

    @Test
    fun `validate state sucess cart pending state`() = runBlockingTest {

        coEvery {
            homeCallback.hasCacheCart()
        } returns true
        viewModel.init()
        assert(viewModel.viewState.value is HomeViewState.SucessCartPending)
    }

    @Test
    fun `validate state false cart pending state`() = runBlockingTest {
        coEvery {
            homeCallback.hasCacheCart()
        } returns false
        viewModel.init()
        assert(viewModel.viewState.value is HomeViewState.GoneCartPending)
    }

}

