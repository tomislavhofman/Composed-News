package hr.hofman.composednews.data.mapper

import hr.hofman.composednews.data.local.entity.SourceEntity
import hr.hofman.composednews.domain.model.Headline.Source
import javax.inject.Singleton

@Singleton
class SourceToEntity : Mapper<Source, SourceEntity> {
    override fun map(from: Source): SourceEntity = SourceEntity(
        id = from.id,
        name = from.name
    )
}
