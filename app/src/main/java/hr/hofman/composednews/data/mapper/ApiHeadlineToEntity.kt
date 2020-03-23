package hr.hofman.composednews.data.mapper

import hr.hofman.composednews.data.local.entity.HeadlineEntity
import hr.hofman.composednews.data.remote.NewsApiHeadline
import org.threeten.bp.Instant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHeadlineToEntity @Inject constructor(private val apiSourceToEntity: ApiSourceToEntity) :
    Mapper<NewsApiHeadline, HeadlineEntity> {

    override fun map(from: NewsApiHeadline): HeadlineEntity =
        HeadlineEntity(
            source = apiSourceToEntity.map(from.source),
            author = from.author ?: "",
            title = from.title ?: "",
            description = from.description ?: "",
            url = from.url ?: "",
            urlToImage = from.urlToImage ?: "",
            publishedAt = Instant.parse(from.publishedAt)
        )
}