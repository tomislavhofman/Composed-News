package hr.hofman.composednews.data.mappers

import hr.hofman.composednews.data.local.Source
import hr.hofman.composednews.data.remote.NewsApiSource
import javax.inject.Singleton

@Singleton
class NewsApiArticleSourceToSource : Mapper<NewsApiSource, Source> {

    override fun map(from: NewsApiSource): Source =
        Source(
            id = from.id ?: "",
            name = from.name
        )
}
