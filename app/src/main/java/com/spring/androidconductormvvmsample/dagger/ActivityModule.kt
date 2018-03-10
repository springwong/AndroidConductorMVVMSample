package com.spring.androidconductormvvmsample.dagger

import android.app.Activity
import com.spring.androidconductormvvmsample.viewModel.SimpleViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by spring on 10/3/2018.
 */
@Module
class ActivityModule(private val activity : Activity) {
    @Provides
    @Singleton
    fun providesSimpleViewModel() : SimpleViewModel = SimpleViewModel()
}