package com.spring.androidconductormvvmsample.dagger

import com.spring.androidconductormvvmsample.MainActivity
import com.spring.androidconductormvvmsample.MainApplication
import dagger.Component
import javax.inject.Singleton

/**
 * Created by spring on 10/3/2018.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application : MainApplication)
    fun inject(mainActivity: MainActivity)
}