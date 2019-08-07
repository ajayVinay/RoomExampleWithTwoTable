package com.demo.room.database3

import android.app.Application
import android.util.Log
import com.demo.room.database3.data.local.DatabaseService
import com.demo.room.database3.data.remote.NetworkService
import com.demo.room.database3.di.components.ApplicationComponent
import com.demo.room.database3.di.components.DaggerApplicationComponent
import com.demo.room.database3.di.modules.ApplicationModule
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import javax.inject.Inject

class MyApplication : Application(){

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var networkHelper: NetworkHelper


    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies(){

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

            applicationComponent.inject(this)

        Log.d("DEBUG", "${networkService.someData}")

    }
}