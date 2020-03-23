package hr.hofman.composednews.data.mapper

import hr.hofman.composednews.data.local.entity.HeadlineEntity
import hr.hofman.composednews.data.local.entity.SourceEntity
import hr.hofman.composednews.domain.model.Headline
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EntityHeadlineToDomain @Inject constructor(private val entitySourceToSource: EntitySourceToSource) :
    Mapper<HeadlineEntity, Headline> {

    override fun map(from: HeadlineEntity): Headline = Headline(
        id = from.id,
        source = entitySourceToSource.map(from.source ?: SourceEntity.EMPTY),
        author = from.author ?: "",
        title = from.title ?: "",
        description = from.description ?: "",
        url = from.url ?: "",
        urlToImage = from.urlToImage ?: "",
        publishedAt = from.publishedAt
    )
}