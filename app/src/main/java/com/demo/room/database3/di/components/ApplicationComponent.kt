package com.demo.room.database3.di.components

import com.demo.room.database3.MyApplication
import com.demo.room.database3.data.local.DatabaseService
import com.demo.room.database3.data.remote.NetworkService
import com.demo.room.database3.di.modules.ApplicationModule
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    fun getDatabaseService(): DatabaseService

    fun getNetworkService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable
}