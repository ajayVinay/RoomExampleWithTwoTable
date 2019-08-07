package com.demo.room.database3.di.components

import com.demo.room.database3.di.ActivityScope
import com.demo.room.database3.di.modules.ActivityModule
import com.demo.room.database3.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}