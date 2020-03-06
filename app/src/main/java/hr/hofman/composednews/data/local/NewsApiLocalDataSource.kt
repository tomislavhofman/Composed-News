package hr.hofman.composednews.data.local

import hr.hofman.composednews.data.ComposedNewsLocalDataSource
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class NewsApiLocalDataSource @Inject constructor() : ComposedNewsLocalDataSource {
    override fun getHeadlines(countryCode: String): Flowable<List<Article>> {
        TODO("Not yet implemented")
    }
}