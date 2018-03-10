package com.spring.androidconductormvvmsample.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import com.jakewharton.rxbinding2.view.clicks
import com.spring.androidconductormvvmsample.MainActivity
import com.spring.androidconductormvvmsample.R
import com.spring.androidconductormvvmsample.viewModel.SimpleViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.controller_detail.view.*
import javax.inject.Inject

/**
 * Created by spring on 10/3/2018.
 */
class DetailController : Controller() {
    @Inject
    lateinit var viewModel : SimpleViewModel

    init {
        MainActivity.graph.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_detail, container, false)
        viewModel.getMyProfile().observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    next -> view.tvName.text = next.login
                    view.tvLastUpdateDate.text = next.updated_at
                }, {
                    error ->
                })
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        view.btnPopPush.clicks().subscribe({
            next -> router.popCurrentController()
            router.pushController(RouterTransaction.with(DetailController()).pushChangeHandler(VerticalChangeHandler()))
        })
    }
}