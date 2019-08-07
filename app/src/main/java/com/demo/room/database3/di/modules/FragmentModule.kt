package com.demo.room.database3.di.modules

import android.content.Context
import androidx.fragment.app.Fragment
import com.demo.room.database3.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @ActivityScope
    fun provideContext(): Context = fragment.context!!

}