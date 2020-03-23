package hr.hofman.composednews.data.mapper

interface Mapper<F, T> {
    fun map(from: F): T
}

fun <F, T> Mapper<F, T>.toListMapper(): (List<F>) -> List<T> {
    return { list -> list.map { item -> map(item) }}
}