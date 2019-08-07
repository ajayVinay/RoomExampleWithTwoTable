package com.demo.room.database3.data.local.dao

import androidx.room.*
import com.demo.room.database3.data.local.entity.Address
import com.demo.room.database3.data.local.entity.User
import io.reactivex.Single

@Dao
interface AddressDao {

    @Insert
    fun insert(address: Address): Single<Long> // If the @Insert method receives only 1 parameter, it can return a long, which is the new rowId for the inserted item

    @Update
    fun updateAddress(address: Address): Single<Int> //This method return an int value instead, indicating the number of rows updated in the database

    @Delete
    fun deleteAddress(address: Address): Single<Int> //This method return an int value instead, indicating the number of rows removed from the database.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg address: Address): Single<List<Long>> //If the @Insert method
                                                            //receives only 1 parameter,
                                                            //it can return a long, which
                                                            //is the new rowId for the inserted
                                                            //item. If the parameter is an array
                                                            //or a collection, it should return
                                                            //long[] or List<Long> instead.

    @Query("SELECT count(*) FROM address")
    fun count(): Single<Int>

    @Query("SELECT * FROM address")
    fun getAllAddress(): Single<List<Address>>

    @Query("SELECT * FROM address where id = :id LIMIT 1")
    fun getAddressById(id: Long): Single<Address>
}