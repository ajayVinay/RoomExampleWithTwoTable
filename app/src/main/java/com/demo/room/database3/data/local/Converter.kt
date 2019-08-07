package com.demo.room.database3.data.local

import androidx.room.*
import java.util.*

class Converter {

    @TypeConverter
    fun fromTimestamp(value: Long?) =value?.let {

        Date(it)
    }

    @TypeConverter
    fun fromDate(date: Date?) = date?.let {

        it.time
    }
}