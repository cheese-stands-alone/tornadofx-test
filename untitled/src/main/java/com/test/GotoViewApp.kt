package com.test

import javafx.application.Application
import tornadofx.*

/**
 * Created by RJ on 3/22/2017.
 */
class SwitchViewApp : App(SubView1::class)

class SubView1 : View("SubView2") {
    val view = this
    override val root = hbox {
        button("switch view") {
            setOnAction {
                view.replaceWith(SubView2::class, ViewTransition.Slide(0.2.seconds))
            }
        }
    }
}

class SubView2 : View("SubView2") {
    val view = this
    override val root = hbox {
        vbox {
            button("switch view") {
                setOnAction {
                    view.replaceWith(SubView1::class, ViewTransition.Slide(0.2.seconds))
                }
            }
            button("Another Button")
        }
        vbox {
            button("Another Button")
            button("Another Button")
        }
    }
}

fun main(args: Array<String>) {
    Application.launch(SwitchViewApp::class.java)
}