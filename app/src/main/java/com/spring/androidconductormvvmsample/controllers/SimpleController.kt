package com.spring.androidconductormvvmsample.controllers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.jakewharton.rxbinding2.view.clicks
import com.spring.androidconductormvvmsample.MainActivity
import com.spring.androidconductormvvmsample.R
import com.spring.androidconductormvvmsample.config.LOG_TAG
import com.spring.androidconductormvvmsample.viewModel.SimpleViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.controller_simple.view.*
import javax.inject.Inject

/**
 * Created by spring on 10/3/2018.
 */
class SimpleController : Controller (){
    @Inject
    lateinit var viewModel : SimpleViewModel
    
    init {
        MainActivity.graph.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_simple, container, false)
        viewModel.getMyProfile()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ next -> view.tvField.text = next.login}, { error -> error.printStackTrace()})
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        getView()?.ivLauncher?.clicks()?.subscribe({
            next -> Log.d(LOG_TAG, "Clicked launcher")
        })
    }
}