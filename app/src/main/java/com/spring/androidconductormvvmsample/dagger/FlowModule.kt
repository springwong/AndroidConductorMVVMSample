package com.spring.androidconductormvvmsample.dagger

import android.app.Activity
import com.bluelinelabs.conductor.Router
import com.spring.androidconductormvvmsample.controllers.FlowControl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by spring on 10/3/2018.
 */
@Module
class FlowModule(private val rout : Router) {

    private var  router : Router = rout

    @Provides
    fun provideRouter() : Router {
        return router
    }

    @Singleton
    @Provides
    fun provideFlowControl(router : Router) : FlowControl = FlowControl(router)
}