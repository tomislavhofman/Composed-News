package hr.hofman.composednews.di

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
object ThreadingModule {

    const val MAIN_SCHEDULER = "main_scheduler"
    const val BACKGROUND_SCHEDULER = "background_scheduler"

    @JvmStatic
    @Provides
    @Singleton
    @Named(MAIN_SCHEDULER)
    fun provideMainScheduler() = AndroidSchedulers.mainThread()

    @JvmStatic
    @Provides
    @Singleton
    @Named(BACKGROUND_SCHEDULER)
    fun provideBackgroundScheduler() = Schedulers.io()
}