package hr.hofman.composednews.ui.home

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentBuilder {

    @ContributesAndroidInjector(
        modules = [HomeAssistedModule::class]
    )
    abstract fun fragment(): HomeFragment
}

@AssistedModule
@Module(includes = [AssistedInject_HomeAssistedModule::class])
interface HomeAssistedModule