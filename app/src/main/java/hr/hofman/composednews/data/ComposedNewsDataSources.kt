package hr.hofman.composednews.data

import hr.hofman.composednews.data.remote.NewsApiHeadline
import hr.hofman.composednews.domain.model.Headline
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface ComposedNewsRemoteDataSource {
    fun getHeadlines(countryCode: String = "us"): Single<List<NewsApiHeadline>>
}

interface ComposedNewsLocalDataSources {
    fun getHeadlines(countryCode: String = "us"): Flowable<List<Headline>>

    fun saveHeadlines(list: List<Headline>): Single<List<Headline>>

    fun removeAllHeadlines(): Completable
}