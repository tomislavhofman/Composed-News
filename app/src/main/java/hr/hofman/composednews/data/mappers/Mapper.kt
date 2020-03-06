package hr.hofman.composednews.data.mappers

interface Mapper<F, T> {
    fun map(from: F): T
}
