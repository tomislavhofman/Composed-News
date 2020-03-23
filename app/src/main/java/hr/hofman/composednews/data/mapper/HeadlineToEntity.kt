package hr.hofman.composednews.data.mapper

import hr.hofman.composednews.data.local.entity.HeadlineEntity
import hr.hofman.composednews.domain.model.Headline
import org.threeten.bp.Instant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeadlineToEntity @Inject constructor(private val sourceToEntity: SourceToEntity) :
    Mapper<Headline, HeadlineEntity> {

    override fun map(from: Headline): HeadlineEntity = HeadlineEntity(
        source = sourceToEntity.map(from.source),
        author = from.author,
        title = from.title,
        description = from.description,
        url = from.url,
        urlToImage = from.urlToImage,
        publishedAt = from.publishedAt
    )
}