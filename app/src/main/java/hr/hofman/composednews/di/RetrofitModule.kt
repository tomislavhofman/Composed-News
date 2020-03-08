package hr.hofman.composednews.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import hr.hofman.composednews.BuildConfig
import hr.hofman.composednews.data.network.NewsApiService
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
object RetrofitModule {

    private const val BASE_URL = "http://newsapi.org/v2/"

    @JvmStatic @Singleton @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.HEADERS
            }
        }
    }

    @JvmStatic @Singleton @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Chain): Response {
                    val newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer" + BuildConfig.NEWS_API_KEY)
                        .build()
                    return chain.proceed(newRequest)
                }
            }).build()

    @JvmStatic @Singleton @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


    @JvmStatic @Singleton @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): Converter.Factory =
        MoshiConverterFactory.create(moshi)

    @JvmStatic @Singleton @Provides
    @Named("news-api")
    fun provideNewsApiKey(): String = BuildConfig.NEWS_API_KEY

    @JvmStatic @Singleton @Provides
    fun provideNewsApiService(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): NewsApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory(okHttpClient)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NewsApiService::class.java)
}