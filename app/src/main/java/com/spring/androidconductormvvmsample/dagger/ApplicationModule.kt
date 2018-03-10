package com.spring.androidconductormvvmsample.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by spring on 10/3/2018.
 */
@Module
class ApplicationModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideApplicationContext() : Context = application

    @Provides
    @Singleton
    fun provideSimpleString() : String = "Simple String"
}