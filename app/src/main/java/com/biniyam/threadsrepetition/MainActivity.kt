package com.biniyam.threadsrepetition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("thread name:  ${Thread.currentThread().name}")
        val looper = LoooperThread(this)

        val newThread = Thread(looper) // new thread started


        newThread.start()

        val button = findViewById<Button>(R.id.btn)
        button.setOnClickListener{
           looper.handler.sendMessage(Message().apply { obj = "from the main thread" })
        }

    }
    fun function(){

             println("outside of run on ui thread.thread name  : ${Thread.currentThread().name}")
            runOnUiThread {
                println("(run on ui thread.thread name  : ${Thread.currentThread().name}")
            }
    }
}