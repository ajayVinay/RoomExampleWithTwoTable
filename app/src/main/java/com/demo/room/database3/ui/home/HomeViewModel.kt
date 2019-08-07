package com.demo.room.database3.ui.home

import com.demo.room.database3.data.local.DatabaseService
import com.demo.room.database3.data.remote.NetworkService
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import javax.inject.Inject

class HomeViewModel @Inject constructor(
                    private val databaseService: DatabaseService,
                    private val networkService: NetworkService,
                    private val networkHelper: NetworkHelper
                   ) {

    companion object{

        const val TAG = "HomeViewModel"
    }
    val someData: String
    get() = "${networkService.someData}"
}