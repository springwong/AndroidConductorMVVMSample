package com.spring.androidconductormvvmsample

import android.app.Application
import android.util.Log
import com.spring.androidconductormvvmsample.config.TAG
import com.spring.androidconductormvvmsample.dagger.ApplicationComponent
import com.spring.androidconductormvvmsample.dagger.ApplicationModule
import com.spring.androidconductormvvmsample.dagger.DaggerApplicationComponent
import javax.inject.Inject

/**
 * Created by spring on 10/3/2018.
 */
class MainApplication : Application() {
    companion object {
        @JvmStatic lateinit var graph : ApplicationComponent
    }

    @Inject
    lateinit var simpleString : String

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        graph.inject(this)

        Log.d(TAG, "Simple String :" + simpleString)
    }
}