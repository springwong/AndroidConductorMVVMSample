package com.spring.androidconductormvvmsample.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.spring.androidconductormvvmsample.R

/**
 * Created by spring on 10/3/2018.
 */
class SimpleController : Controller (){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_simple, container, false)
        return view
    }
}