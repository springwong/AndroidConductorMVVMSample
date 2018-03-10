package com.spring.androidconductormvvmsample.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.spring.androidconductormvvmsample.MainActivity
import com.spring.androidconductormvvmsample.R
import com.spring.androidconductormvvmsample.viewModel.SimpleViewModel
import javax.inject.Inject

/**
 * Created by spring on 10/3/2018.
 */
class SimpleController : Controller (){
    @Inject
    lateinit var viewModel : SimpleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        MainActivity.graph.inject(this)
        val view = inflater.inflate(R.layout.controller_simple, container, false)
        viewModel.helloWorld()
        return view
    }
}