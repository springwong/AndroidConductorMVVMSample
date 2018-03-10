package com.spring.androidconductormvvmsample.dagger

import com.spring.androidconductormvvmsample.MainActivity
import com.spring.androidconductormvvmsample.controllers.SimpleController
import dagger.Component
import javax.inject.Singleton

/**
 * Created by spring on 10/3/2018.
 */
@Singleton
@Component(modules =  arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(simpleController: SimpleController)
}