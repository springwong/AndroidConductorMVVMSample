package com.spring.androidconductormvvmsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.spring.androidconductormvvmsample.config.LOG_TAG
import com.spring.androidconductormvvmsample.controllers.SimpleController
import com.spring.androidconductormvvmsample.dagger.ActivityComponent
import com.spring.androidconductormvvmsample.dagger.ActivityModule
import com.spring.androidconductormvvmsample.dagger.ApplicationComponent
import com.spring.androidconductormvvmsample.dagger.DaggerActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    private lateinit var router : Router

    companion object {
        @JvmStatic lateinit var graph : ActivityComponent
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainApplication.graph.inject(this)
        graph = DaggerActivityComponent.builder().activityModule(ActivityModule(this)).build()

        router = Conductor.attachRouter(this, this.mainContainer, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(SimpleController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}
