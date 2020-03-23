package hr.hofman.composednews.data.local

import hr.hofman.composednews.data.ComposedNewsLocalDataSources
import hr.hofman.composednews.data.local.dao.HeadlinesDao
import hr.hofman.composednews.data.mapper.EntityHeadlineToDomain
import hr.hofman.composednews.data.mapper.HeadlineToEntity
import hr.hofman.composednews.data.mapper.toListMapper
import hr.hofman.composednews.domain.model.Headline
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class HeadlinesStore @Inject constructor(
    private val headlinesDao: HeadlinesDao,
    private val entityHeadlineToDomain: EntityHeadlineToDomain,
    private val headlineToEntity: HeadlineToEntity
) : ComposedNewsLocalDataSources {

    override fun getHeadlines(countryCode: String): Flowable<List<Headline>> {
        return headlinesDao.headlines().map(entityHeadlineToDomain.toListMapper())
    }

    override fun saveHeadlines(list: List<Headline>): Single<List<Headline>> {
        return Completable.fromCallable {
                headlinesDao.insertAll(
                    headlineToEntity.toListMapper()(
                        list
                    )
                )
            }
            .andThen(Single.just(list))
    }

    override fun removeAllHeadlines(): Completable {
        return Completable.fromCallable { headlinesDao.deleteAll() }
    }
}