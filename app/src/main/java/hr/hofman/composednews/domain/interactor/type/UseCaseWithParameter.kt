package hr.hofman.composednews.domain.interactor.type

import io.reactivex.Flowable

interface UseCaseWithParameter<P, R> {
    fun execute(parameter: P): Flowable<R>
}
