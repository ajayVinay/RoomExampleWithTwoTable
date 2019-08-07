package com.demo.room.database3.data.local.dao

import androidx.room.*
import com.demo.room.database3.data.local.entity.User
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert
    fun insert(user: User): Single<Long> // If the @Insert method receives only 1 parameter, it can return a long, which is the new rowId for the inserted item

    @Update
    fun updateUser(user: User): Single<Int> //This method return an int value instead, indicating the number of rows updated in the database

    @Delete
    fun deleteUser(user: User): Single<Int> //This method return an int value instead, indicating the number of rows removed from the database.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg user: User): Single<List<Long>> //If the @Insert method
                                                          //receives only 1 parameter,
                                                          //it can return a long, which
                                                          //is the new rowId for the inserted
                                                          //item. If the parameter is an array
                                                          //or a collection, it should return
                                                          //long[] or List<Long> instead.

    @Query("SELECT count(*) FROM users")
    fun count():Single<Int>

    @Query("SELECT * FROM users")
    fun getAllUser(): Single<List<User>>

    @Query("SELECT * FROM users where id = :id LIMIT 1")
    fun getUserById(id: Long): Single<User>

}