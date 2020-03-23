package hr.hofman.composednews.di

import android.content.Context
import dagger.Module
import dagger.Provides
import hr.hofman.composednews.ComposedNews

@Module
class ApplicationModule {

    @Provides
    fun providesContext(application: ComposedNews): Context = application.applicationContext
}