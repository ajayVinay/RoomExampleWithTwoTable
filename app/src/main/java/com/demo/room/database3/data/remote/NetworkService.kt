package com.demo.room.database3.data.remote

import android.content.Context
import com.demo.room.database3.di.ApplicationContext
import com.demo.room.database3.di.NetworkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkService @Inject constructor(
                    //context must be application context
    @ApplicationContext private val context: Context,
    @NetworkInfo private val apiKey: String
                    )
{
    val someData:String
    get() = "$apiKey"
}