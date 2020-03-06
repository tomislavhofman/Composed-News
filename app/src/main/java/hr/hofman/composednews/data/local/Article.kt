package hr.hofman.composednews.data.local

import org.threeten.bp.Instant

data class Article(
    val source: Source, val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Instant
)

data class Source(
    val id: String,
    val name: String
)