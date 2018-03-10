package com.spring.androidconductormvvmsample.dagger

import com.spring.androidconductormvvmsample.retrofit.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by spring on 10/3/2018.
 */
@Module
class NetModule {
    @Provides
    @Singleton
    fun provideGitHubService() : GithubService {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(GithubService::class.java)
    }
}