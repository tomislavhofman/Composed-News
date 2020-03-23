package hr.hofman.composednews

import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.MvRxViewModelConfigFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import hr.hofman.composednews.di.DaggerApplicationComponent

class ComposedNews : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        MvRx.viewModelConfigFactory = MvRxViewModelConfigFactory(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }
}