package com.biniyam.threadsrepetition

import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlin.concurrent.thread

class LoooperThread(val activity: MainActivity):Runnable {

    public lateinit var handler: Handler
    override fun run() {
        println("thread started")
        println("thread name:  ${Thread.currentThread().name}")

        Looper.prepare() // queue heap handler handles all the queue and messages between messages and wait like traffic lines staffet
         handler = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {
                println("Received message: ${msg.obj}")
                println("handler lives in : ${Thread.currentThread().name}")
            }
        }

        handler.sendMessage(Message().apply { obj = "form inside the new thread" })
        println("thread name : ${Thread.currentThread().name}")
        Thread.sleep(5000)

        activity.function()
        Looper.loop()


    }
}