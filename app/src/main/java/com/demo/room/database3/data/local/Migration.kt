package com.demo.room.database3.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val migration_1_2= object :Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Address ADD COLUMN street INTEGER NOT NULL DEFAULT 0" )
    }

}

val migration_2_3= object :Migration(2,3){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE users ADD COLUMN designation TEXT NOT NULL DEFAULT ''" )
    }

}