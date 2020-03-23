package hr.hofman.composednews.data

import dagger.Binds
import dagger.Module
import hr.hofman.composednews.data.local.HeadlinesStore
import hr.hofman.composednews.data.remote.HeadlinesRemoteDataSource


@Module
abstract class DataModule {

    @Binds
    abstract fun bindComposedNewsRemoteDataSource(source: HeadlinesRemoteDataSource): ComposedNewsRemoteDataSource

    @Binds
    abstract fun bindComposedNewsLocalDataSource(source: HeadlinesStore): ComposedNewsLocalDataSources
}