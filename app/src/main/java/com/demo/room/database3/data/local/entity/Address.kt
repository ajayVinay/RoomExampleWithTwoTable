package com.demo.room.database3.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Address")
data class Address(

           @PrimaryKey(autoGenerate = true)
           var id: Long = 0,

           @ColumnInfo(name = "city")
           var city: String,

           @ColumnInfo(name = "country")
           var country: String,

           @ColumnInfo(name = "code")
           var code: Int,

           @ColumnInfo(name = "street")
           var street:Int

                  )
{
    constructor(): this(0,"","",0,street=0)
}