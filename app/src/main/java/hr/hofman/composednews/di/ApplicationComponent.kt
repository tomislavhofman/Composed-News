package hr.hofman.composednews.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import hr.hofman.composednews.ComposedNews
import hr.hofman.composednews.data.DataModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        HomeBuilder::class,
        RetrofitModule::class,
        ThreadingModule::class,
        DatabaseModule::class,
        DataModule::class]
)
interface ApplicationComponent : AndroidInjector<ComposedNews> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: ComposedNews): ApplicationComponent
    }
}