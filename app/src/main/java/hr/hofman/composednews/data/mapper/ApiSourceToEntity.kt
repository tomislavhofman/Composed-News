package hr.hofman.composednews.data.mapper

import hr.hofman.composednews.data.local.entity.SourceEntity
import hr.hofman.composednews.data.remote.NewsApiSource
import javax.inject.Singleton

@Singleton
class ApiSourceToEntity : Mapper<NewsApiSource, SourceEntity> {
    override fun map(from: NewsApiSource): SourceEntity =
        SourceEntity(
            id = from.id ?: "",
            name = from.name
        )
}
