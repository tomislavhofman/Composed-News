package hr.hofman.composednews.data.mappers

import hr.hofman.composednews.data.local.Article
import hr.hofman.composednews.data.remote.NewsApiArticle
import org.threeten.bp.Instant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsApiArticleToArticle @Inject constructor(private val newsApiSourceToSource: NewsApiArticleSourceToSource) :
    Mapper<NewsApiArticle, Article> {

    override fun map(from: NewsApiArticle): Article =
        Article(
            source = newsApiSourceToSource.map(from.source),
            author = from.author ?: "",
            title = from.title ?: "",
            description = from.description ?: "",
            url = from.url ?: "",
            urlToImage = from.urlToImage ?: "",
            publishedAt = Instant.parse(from.publishedAt)
        )
}