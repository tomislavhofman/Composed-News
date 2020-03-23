package hr.hofman.composednews.data.repository

import hr.hofman.composednews.data.ComposedNewsLocalDataSources
import hr.hofman.composednews.data.ComposedNewsRemoteDataSource
import hr.hofman.composednews.data.instantInPast
import hr.hofman.composednews.data.local.HeadlinesLastRequestStore
import hr.hofman.composednews.domain.model.Headline
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import org.threeten.bp.Instant
import javax.inject.Inject

class HeadlinesRepository @Inject constructor(
    private val localDataSource: ComposedNewsLocalDataSources,
    private val remoteDataSource: ComposedNewsRemoteDataSource,
    private val lastRequestStore: HeadlinesLastRequestStore,
    private val backgroundScheduler: Scheduler
) {
    fun getAll(
        countryCode: String = "us"
    ): Flowable<List<Headline>> {
        return Flowable.defer {
            localDataSource.getHeadlines(countryCode = countryCode)
        }.subscribeOn(backgroundScheduler)
    }

    fun saveAll(headlines: List<Headline>): Single<List<Headline>> {
        return Single.defer {
            localDataSource.saveHeadlines(headlines)
        }
    }

    fun removeAll(): Completable {
        return Completable.defer {
            localDataSource.removeAllHeadlines()
        }
    }

    private fun needUpdate(expiry: Instant = instantInPast(hours = 1)): Boolean {
        return lastRequestStore.isRequestBefore(expiry)
    }
}