package hr.hofman.composednews.di

import android.content.Context
import dagger.Module
import dagger.Provides
import hr.hofman.composednews.ComposedNewsApplication

@Module
class AppModule {

    @Provides
    fun providesContext(application: ComposedNewsApplication): Context = application.applicationContext
}