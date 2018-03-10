package com.spring.androidconductormvvmsample.viewModel

import android.util.Log
import com.spring.androidconductormvvmsample.MainActivity
import com.spring.androidconductormvvmsample.config.LOG_TAG
import com.spring.androidconductormvvmsample.retrofit.GithubService
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by spring on 10/3/2018.
 */
class SimpleViewModel {
    @Inject
    lateinit var service: GithubService

    constructor() {
        MainActivity.graph.inject(this)
    }

    fun helloWorld() {
        Log.d(LOG_TAG, "Hello World")
        service.getMyProfile().subscribeOn(Schedulers.newThread()).subscribe({ next -> Log.d(LOG_TAG, "Github name : " + next.login)}, { error -> error.printStackTrace()})
    }
}