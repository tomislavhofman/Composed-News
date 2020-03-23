package hr.hofman.composednews.ui.headlines

import com.airbnb.mvrx.MvRxState
import hr.hofman.composednews.domain.model.Headline

data class HeadlinesViewState(val headlines: List<Headline>) : MvRxState