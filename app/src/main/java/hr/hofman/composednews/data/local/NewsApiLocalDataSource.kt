package hr.hofman.composednews.data.local

import hr.hofman.composednews.data.ComposedNewsLocalDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class NewsApiLocalDataSource @Inject constructor() : ComposedNewsLocalDataSource {
    override fun getHeadlines(countryCode: String): Flowable<List<Headline>> {
        TODO("Not yet implemented")
    }
}