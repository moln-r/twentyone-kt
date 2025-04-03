package com.github.molnr.logging

class DummyLogger(private val debugEnabled: Boolean) {

    fun info(message: String) {
        println(message)
    }

    fun debug(message: String) {
        if (debugEnabled) {
            println("debug: $message")
        }
    }

}