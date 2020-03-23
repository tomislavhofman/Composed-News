package hr.hofman.composednews.domain.interactor.type

import io.reactivex.Flowable

interface UseCase<T> {
    fun execute(): Flowable<T>
}