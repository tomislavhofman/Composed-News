package hr.hofman.composednews.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import hr.hofman.composednews.MainActivity
import hr.hofman.composednews.base.AppNavigator
import hr.hofman.composednews.ui.home.HomeAppNavigator
import hr.hofman.composednews.ui.home.HomeFragmentBuilder

@Module
internal abstract class HomeBuilder {
    @ContributesAndroidInjector(
        modules = [
            HomeFragmentBuilder::class]
    )
    abstract fun homeActivity(): MainActivity
}

@Module(includes = [HomeModuleBinds::class])
class HomeModule {
    @Provides
    fun provideAppNavigator(activity: MainActivity): AppNavigator = HomeAppNavigator(activity)
}

@Module
abstract class HomeModuleBinds {
    @Binds
    @PerActivity
    abstract fun bindContext(activity: MainActivity): Context
}
