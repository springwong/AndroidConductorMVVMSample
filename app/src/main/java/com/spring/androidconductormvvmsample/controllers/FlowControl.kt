package com.spring.androidconductormvvmsample.controllers

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import okhttp3.Route

/**
 * Created by spring on 10/3/2018.
 */
class FlowControl constructor(router : Router) {
    private var router : Router = router
    fun present(controller : Controller) {
        router.pushController(RouterTransaction.with(controller)
                .pushChangeHandler(VerticalChangeHandler())
                .popChangeHandler(VerticalChangeHandler()))
    }

    fun push(controller: Controller) {
        router.pushController(RouterTransaction.with(controller)
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
        )
    }

    fun presentFromRoot(controller: Controller) {
        router.popToRoot()
        present(controller)
    }
}