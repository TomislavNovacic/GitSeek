package com.tomislav.novacic.gitseek.di.module

import com.tomislav.novacic.gitseek.data.source.remote.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule {

    private val BASE_URL = "https://api.github.com"

    @Singleton
    @Provides
    fun provideRetrofitService(): ApiInterface {
        val okHttpClient: OkHttpClient by lazy {
            OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
        }
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiInterface::class.java)
    }
}