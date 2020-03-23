package hr.hofman.composednews.domain.interactor.type

import io.reactivex.Single

interface SingleUseCaseWithParameter<P, R> {
    fun execute(parameter: P): Single<R>
}
