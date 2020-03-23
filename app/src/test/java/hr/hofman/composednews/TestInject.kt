package hr.hofman.composednews

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Component
import dagger.Module
import dagger.Provides
import hr.hofman.composednews.data.remote.NewsApiService
import hr.hofman.composednews.data.remote.NewsApiServiceTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Singleton
@Component(modules = [TestDataSourceModule::class])
interface TestComponent {
    fun inject(test: NewsApiServiceTest)
}

@Module
object TestDataSourceModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideMockWebServer(): MockWebServer = MockWebServer()

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @JvmStatic
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @JvmStatic
    @Singleton
    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): Converter.Factory =
        MoshiConverterFactory.create(moshi)

    @JvmStatic
    @Singleton
    @Provides
    fun provideNewsApiService(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        mockWebServer: MockWebServer
    ): NewsApiService = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .callFactory(okHttpClient)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NewsApiService::class.java)
}