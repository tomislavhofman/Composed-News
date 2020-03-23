package hr.hofman.composednews.domain.interactor.type

import io.reactivex.Completable


interface CompletableUseCaseWithParameter<P> {
    fun execute(parameter: P): Completable
}
