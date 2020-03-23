package hr.hofman.composednews.di

import javax.inject.Qualifier


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class PerActivity

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class ApplicationId

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class ProcessLifetime
