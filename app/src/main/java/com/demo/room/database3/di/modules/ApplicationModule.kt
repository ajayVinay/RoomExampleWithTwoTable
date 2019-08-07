package com.demo.room.database3.di.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.room.database3.MyApplication
import com.demo.room.database3.data.local.DatabaseService
import com.demo.room.database3.data.local.migration_1_2
import com.demo.room.database3.data.local.migration_2_3
import com.demo.room.database3.di.ApplicationContext
import com.demo.room.database3.di.DatabaseInfo
import com.demo.room.database3.di.NetworkInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {


    @Provides
    @ApplicationContext
    fun provideContext(): Context = application


    @Provides
    @NetworkInfo
    fun provideApiKey():String{

        return "xyz"
    }

    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService = Room.databaseBuilder(

                    application,
                    DatabaseService::class.java,
                    "bootcamp-database-project-db"
              )
        .addMigrations(migration_1_2, migration_2_3)
        .build()

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}