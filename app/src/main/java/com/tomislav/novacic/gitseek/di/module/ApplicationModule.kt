package com.tomislav.novacic.gitseek.di.module

import com.tomislav.novacic.gitseek.data.source.remote.ApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule {

    private val BASE_URL = "https://api.github.com"

    @Singleton
    @Provides
    fun provideRetrofitService(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}