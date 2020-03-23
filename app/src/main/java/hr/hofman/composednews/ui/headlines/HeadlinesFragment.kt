package hr.hofman.composednews.ui.headlines

import com.airbnb.mvrx.fragmentViewModel
import hr.hofman.composednews.base.FragmentBase
import javax.inject.Inject

class HeadlinesFragment : FragmentBase() {

    @Inject lateinit var headlinesViewModelFactory: HeadlinesViewModel.Factory
    private val viewModel: HeadlinesViewModel by fragmentViewModel()

    override fun invalidate() {
        // TODO()
    }
}