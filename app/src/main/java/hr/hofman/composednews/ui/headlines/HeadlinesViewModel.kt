package hr.hofman.composednews.ui.headlines

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import hr.hofman.composednews.domain.interactor.headlines.ObserveHeadlinesUseCase

class HeadlinesViewModel @AssistedInject constructor(
    @Assisted initialState: HeadlinesViewState,
    getHeadlinesUseCase: ObserveHeadlinesUseCase
) : BaseMvRxViewModel<HeadlinesViewState>(initialState) {

    init {
        getHeadlinesUseCase.execute("us").toObservable().execute {
            copy(headlines = it() ?: emptyList())
        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(initialState: HeadlinesViewState): HeadlinesViewModel
    }

    companion object : MvRxViewModelFactory<HeadlinesViewModel, HeadlinesViewState> {

        override fun create(
            viewModelContext: ViewModelContext,
            state: HeadlinesViewState
        ): HeadlinesViewModel? {
            val fragment: HeadlinesFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.headlinesViewModelFactory.create(state)
        }
    }
}
