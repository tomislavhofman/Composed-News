package hr.hofman.composednews.data.mapper

import hr.hofman.composednews.data.local.entity.SourceEntity
import hr.hofman.composednews.domain.model.Headline.Source
import javax.inject.Singleton

@Singleton
class EntitySourceToSource : Mapper<SourceEntity, Source> {
    override fun map(from: SourceEntity): Source = Source(
        id = from.id,
        name = from.name
    )
}