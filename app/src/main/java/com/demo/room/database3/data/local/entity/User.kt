package com.demo.room.database3.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "users",
        foreignKeys = [
                       ForeignKey(
                                  entity = Address::class,
                                  parentColumns = ["id"],
                                  childColumns = ["address_id"],
                                  onDelete = ForeignKey.CASCADE
                                 )
                     ]
)
data class User(

        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "dateOfBirth")
        var dateOfBirth: Date,

        @ColumnInfo(name = "company_name")
        var companyName: String,

        @ColumnInfo(name = "designation")
        var designation: String,

        @ColumnInfo(name = "address_id")
        var addressId: Long

       )
{

    constructor(): this(0,"",Date(),"","",0)
}