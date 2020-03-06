package hr.hofman.composednews.data.remote

import hr.hofman.composednews.AppSchedulers
import hr.hofman.composednews.data.ComposedNewsRemoteDataSource
import hr.hofman.composednews.data.local.Article
import hr.hofman.composednews.data.mappers.NewsApiArticleToArticle
import hr.hofman.composednews.data.network.NewsApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Provider

class NewsApiRemoteDataSource @Inject constructor(
    private val service: Provider<NewsApiService>,
    private val newsApiMapper: NewsApiArticleToArticle
) : ComposedNewsRemoteDataSource {

    override fun getHeadlines(countryCode: String): Single<List<Article>> {
        return service.get().getTopHeadlines().subscribeOn(AppSchedulers.network)
            .map { response ->
                response.articles
                    .map {
                        newsApiMapper.map(it)
                    }
            }
    }
}