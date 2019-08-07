package com.demo.room.database3.di.modules

import android.app.Activity
import android.content.Context
import com.demo.room.database3.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = activity
}