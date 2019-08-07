package com.demo.room.database3.di.components

import com.demo.room.database3.di.FragmentScope
import com.demo.room.database3.di.modules.FragmentModule
import com.demo.room.database3.ui.home.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(homeFragment: HomeFragment)
}