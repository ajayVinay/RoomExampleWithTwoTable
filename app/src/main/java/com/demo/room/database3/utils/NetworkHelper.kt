package com.mindorks.bootcamp.demo.utils

import android.content.Context
import com.demo.room.database3.di.ApplicationContext


import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(
        // Should be Application Context
        @ApplicationContext private val context: Context) {

    // will check for network connectivity
    val isNetworkConnected: Boolean
        get() = false
}
