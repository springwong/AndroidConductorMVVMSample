package com.spring.androidconductormvvmsample.retrofit

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by spring on 10/3/2018.
 */
interface GithubService {
    @GET("users/springwong")
    fun getMyProfile() : Single<User>
}