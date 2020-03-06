package hr.hofman.composednews.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsApiArticle>
)

@JsonClass(generateAdapter = true)
data class NewsApiArticle(
    val source: NewsApiSource,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String
)


@JsonClass(generateAdapter = true)
data class NewsApiSource(
    val id: String?,
    val name: String
)