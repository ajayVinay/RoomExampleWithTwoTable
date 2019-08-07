package com.demo.room.database3.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.demo.room.database3.data.local.DatabaseService
import com.demo.room.database3.data.local.entity.Address
import com.demo.room.database3.data.local.entity.User
import com.demo.room.database3.data.remote.NetworkService
import com.demo.room.database3.di.ActivityScope
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
                    private val compositeDisposable: CompositeDisposable,
                    private val databaseService: DatabaseService,
                    private val networkService: NetworkService,
                    private val networkHelper: NetworkHelper
                   )
{
    var users = MutableLiveData<List<User>>()

    var address = MutableLiveData<List<Address>>()


    var userList: List<User> = emptyList()

    var addressList: List<Address> = emptyList()

    companion object{

        const val TAG = "MainViewModel"
    }
    init{
        compositeDisposable.add(

            databaseService.getUserDao()
                .count()
                .flatMap {

                    if(it == 0)
                        databaseService.getAddressDao()
                            .insertMany(

                                Address(city = "Noida", country = "India", code = 1, street = 1),
                                Address(city = "Kaliforniya", country = "USA", code = 2,street = 2),
                                Address(city = "Landon", country = "UK", code = 3,street = 3),
                                Address(city = "Sydney", country = "Australy", code = 4,street = 4),
                                Address(city = "Tokiyo", country = "Japan", code = 5,street = 5),
                                Address(city = "Hancong", country = "China", code = 6,street = 6)

                            )
                            .flatMap {addressIdList ->

                                databaseService.getUserDao()
                                    .insertMany(
                                        User(name = "Vinay", companyName = "Umbrella", dateOfBirth = Date(5467789878),designation = "Engineer", addressId = addressIdList[0]),
                                        User(name = "Satya", companyName = "Nagarro",dateOfBirth = Date(5467789878), designation = "Sr.Engineer", addressId = addressIdList[1]),
                                        User(name = "Rohit", companyName = "Tdsys",dateOfBirth = Date(5467789878),designation = "Developer", addressId = addressIdList[2]),
                                        User(name = "Ajaz", companyName = "Amdocs",dateOfBirth = Date(5467789878),designation = "Sr.Developer", addressId = addressIdList[3]),
                                        User(name = "Sunil", companyName = "Amazon",dateOfBirth = Date(5467789878),designation = "Programmer", addressId = addressIdList[4]),
                                        User(name = "Shiv", companyName = "Google",dateOfBirth = Date(5467789878),designation = "Sr.Programmer", addressId = addressIdList[5])
                                    )

                            }
                    else Single.just(0)

                }
                .subscribeOn(Schedulers.io())
                .subscribe(

                    {
                      Log.d(TAG,"User is available in db")
                    },
                    {
                        Log.d(TAG,"Error occures ${it.toString()}")
                    }
                )

        )
    }


    fun getAllUser(){

        compositeDisposable.add(

               databaseService.getUserDao()
                   .getAllUser()
                   .subscribeOn(Schedulers.io())
                   .subscribe(

                       {

                           Log.d(TAG,"User List ${it.toString()}")
                           userList = it

                           users.postValue(it)
                       },
                       {
                           Log.d(TAG,"Error occures ${it.toString()}")
                       }
                   )
        )
    }


    fun getAllAddress(){

        compositeDisposable.add(

            databaseService.getAddressDao()
                .getAllAddress()
                .subscribeOn(Schedulers.io())
                .subscribe(

                    {

                        Log.d(TAG,"Addressist ${it.toString()}")
                        addressList = it

                        address.postValue(it)
                    },
                    {
                        Log.d(TAG,"Error occures ${it.toString()}")
                    }
                )
        )
    }


    fun deleteUser(){

        if(userList.isNotEmpty())
            compositeDisposable.add(
                databaseService.getUserDao()
                    .deleteUser(userList[0])
                    .flatMap {

                        databaseService.getUserDao()
                            .getAllUser()
                    }
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {

                            userList = it
                            users.postValue(it)
                        },
                        {
                            Log.d(TAG,"Error occures ${it.toString()}")
                        }
                    )

            )

    }


    fun deleteAddress(){

        if(addressList.isNotEmpty())
            compositeDisposable.add(
                databaseService.getAddressDao()
                    .deleteAddress(addressList[0])
                    .flatMap {

                        databaseService.getAddressDao()
                            .getAllAddress()
                    }
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {

                            addressList = it
                            address.postValue(it)
                        },
                        {
                            Log.d(TAG,"Error occures ${it.toString()}")
                        }
                    )

            )

    }

    fun onDestroy(){

        compositeDisposable.dispose()
    }


}