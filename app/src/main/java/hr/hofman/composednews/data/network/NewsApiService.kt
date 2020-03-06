package hr.hofman.composednews.data.network

import hr.hofman.composednews.data.remote.NewsApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiService {

    @GET("/top-headlines")
    fun getTopHeadlines(@Query("countryCode") countryCode: String = "us"): Single<NewsApiResponse>
}