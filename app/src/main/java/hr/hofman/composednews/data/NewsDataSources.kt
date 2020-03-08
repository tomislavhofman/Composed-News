package hr.hofman.composednews.data

import hr.hofman.composednews.data.local.Article
import io.reactivex.Flowable
import io.reactivex.Single

interface ComposedNewsLocalDataSource {
    fun getHeadlines(countryCode: String): Flowable<List<Article>>
}

interface ComposedNewsRemoteDataSource {
    fun getHeadlines(countryCode: String): Single<List<Article>>
}