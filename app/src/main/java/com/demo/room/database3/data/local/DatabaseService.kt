package com.demo.room.database3.data.local

import android.content.Context
import androidx.room.*
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.room.database3.data.local.dao.AddressDao
import com.demo.room.database3.data.local.dao.UserDao
import com.demo.room.database3.data.local.entity.Address
import com.demo.room.database3.data.local.entity.User
import com.demo.room.database3.di.ApplicationContext
import com.demo.room.database3.di.DatabaseInfo
import javax.inject.Inject
import javax.inject.Singleton

@Database(entities = [
                      User::class,
                      Address::class
                     ],
                    exportSchema = false,
                    version = 3

                     )

@TypeConverters(Converter::class)
abstract class DatabaseService: RoomDatabase()
{
    abstract fun getUserDao(): UserDao
    abstract fun getAddressDao(): AddressDao
}
