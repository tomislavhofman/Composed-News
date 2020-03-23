package hr.hofman.composednews.domain.interactor.type

import io.reactivex.Completable


interface CompletableUseCase {
    fun execute(): Completable
}
