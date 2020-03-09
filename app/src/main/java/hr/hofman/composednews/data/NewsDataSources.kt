package hr.hofman.composednews.data

import hr.hofman.composednews.data.local.Headline
import io.reactivex.Flowable
import io.reactivex.Single

interface ComposedNewsLocalDataSource {
    fun getHeadlines(countryCode: String): Flowable<List<Headline>>
}

interface ComposedNewsRemoteDataSource {
    fun getHeadlines(countryCode: String): Single<List<Headline>>
}