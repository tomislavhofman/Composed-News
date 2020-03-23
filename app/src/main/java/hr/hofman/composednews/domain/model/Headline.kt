package hr.hofman.composednews.domain.model

import org.threeten.bp.Instant

data class Headline(
    val id: Long,
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Instant?
) {
    data class Source(val id: String, val name: String)
}