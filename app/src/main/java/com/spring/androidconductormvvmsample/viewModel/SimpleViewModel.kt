package com.spring.androidconductormvvmsample.viewModel

import android.util.Log
import com.spring.androidconductormvvmsample.MainActivity
import com.spring.androidconductormvvmsample.config.LOG_TAG
import com.spring.androidconductormvvmsample.retrofit.GithubService
import com.spring.androidconductormvvmsample.retrofit.User
import io.reactivex.Scheduler
import io.reactivex.Single
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

    fun getMyProfile() : Single<User> {
        return service.getMyProfile().subscribeOn(Schedulers.newThread())
    }
}