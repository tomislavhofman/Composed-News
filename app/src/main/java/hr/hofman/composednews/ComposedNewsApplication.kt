package hr.hofman.composednews

import android.app.Application
import hr.hofman.composednews.di.ApplicationComponent
import hr.hofman.composednews.di.DaggerApplicationComponent
import hr.hofman.composednews.di.DaggerComponentProvider

class ComposedNewsApplication : Application(), DaggerComponentProvider {

    override val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationContext(applicationContext)
            .build()
    }
}