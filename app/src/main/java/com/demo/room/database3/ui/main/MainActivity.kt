package com.demo.room.database3.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import com.demo.room.database3.MyApplication
import com.demo.room.database3.R
import com.demo.room.database3.di.components.DaggerActivityComponent
import com.demo.room.database3.di.modules.ActivityModule
import com.demo.room.database3.ui.home.HomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object{

        const val TAG = "MainActivity"
    }

    lateinit var tvData: TextView

    lateinit var tvAddresses : TextView

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        addHomeFragment()
    }

    private fun init(){
        tvData = findViewById(R.id.tv_message)
        tvAddresses = findViewById(R.id.tv_message_2)
        viewModel.users.observe(this, Observer {

            tvData.text = it.toString()
        })

        viewModel.address.observe(this, Observer {

            tvAddresses.text = it.toString()
        })

    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.onDestroy()
    }

    override fun onStop() {
        super.onStop()

        viewModel.deleteAddress()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllAddress()
        viewModel.getAllUser()
    }

    private fun addHomeFragment(){

        if(supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, HomeFragment.getInstance(), TAG)
                .commit()
        }
    }

    private fun getDependencies(){
      DaggerActivityComponent.builder()
          .applicationComponent((application as MyApplication).applicationComponent)
          .activityModule(ActivityModule(this))
          .build()
          .inject(this)


        Log.d("DEBUG", "Working")
    }
}
