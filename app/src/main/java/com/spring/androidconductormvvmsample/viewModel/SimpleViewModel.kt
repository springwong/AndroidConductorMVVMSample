package com.spring.androidconductormvvmsample.viewModel

import android.util.Log
import com.spring.androidconductormvvmsample.MainActivity
import com.spring.androidconductormvvmsample.config.LOG_TAG
import com.spring.androidconductormvvmsample.retrofit.GithubService
import com.spring.androidconductormvvmsample.retrofit.User
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by spring on 10/3/2018.
 */
class SimpleViewModel {
    @Inject
    protected lateinit var service: GithubService
    private var user : User? = null

    constructor() {
        MainActivity.graph.inject(this)
    }

    fun getMyProfile() : Single<User> {
        if (user != null) {
            return Single.just(user)
        }else {
            return service.getMyProfile().doOnSuccess { success -> this.user = success }.subscribeOn(Schedulers.newThread())
        }
    }

    fun clearData() {
        user = null
    }

}