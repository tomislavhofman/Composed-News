package hr.hofman.composednews.domain.interactor.headlines

import hr.hofman.composednews.data.repository.HeadlinesRepository
import hr.hofman.composednews.domain.interactor.type.UseCaseWithParameter
import hr.hofman.composednews.domain.model.Headline
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class ObserveHeadlinesUseCase @Inject constructor(private val headlinesRepository: HeadlinesRepository) :
    UseCaseWithParameter<String, List<Headline>> {

    override fun execute(parameter: String): Flowable<List<Headline>> {
        return headlinesRepository.getAll(parameter)
    }
}