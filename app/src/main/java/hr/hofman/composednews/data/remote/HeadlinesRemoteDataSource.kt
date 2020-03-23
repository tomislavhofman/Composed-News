package hr.hofman.composednews.data.remote

import hr.hofman.composednews.data.ComposedNewsRemoteDataSource
import hr.hofman.composednews.domain.model.Headline
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Provider

class HeadlinesRemoteDataSource @Inject constructor(
    private val service: Provider<NewsApiService>
) : ComposedNewsRemoteDataSource {

    override fun getHeadlines(countryCode: String): Single<List<NewsApiHeadline>> {
        return service.get().getTopHeadlines().subscribeOn(Schedulers.io())
            .map { response ->
                response.articles
            }
    }
}