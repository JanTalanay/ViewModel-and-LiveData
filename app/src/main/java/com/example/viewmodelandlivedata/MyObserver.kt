package com.example.viewmodelandlivedata

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver: LifecycleObserver{
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)

    fun onCreate(){
        Log.i(LOG_TAG, "MainActivity has CREATED")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)

    fun onStart(){
        Log.i(LOG_TAG, "Screen is shown")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)

    fun onStop(){
        Log.i(LOG_TAG, "Screen is not shown")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)

    fun onClose(){
        Log.i(LOG_TAG, "MainActivity has DESTROYED")
    }
}