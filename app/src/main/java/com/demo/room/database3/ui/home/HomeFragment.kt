package com.demo.room.database3.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.demo.room.database3.MyApplication
import com.demo.room.database3.R
import com.demo.room.database3.di.components.DaggerActivityComponent
import com.demo.room.database3.di.components.DaggerFragmentComponent
import com.demo.room.database3.di.modules.FragmentModule
import javax.inject.Inject

class HomeFragment: Fragment() {

    companion object{
        const val TAG = "HomeFragment"

        fun getInstance(): HomeFragment{

            val fragment= HomeFragment()
            val arg = Bundle()
            fragment.arguments = arg
            return fragment
        }
    }

    lateinit var tvData: TextView

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }
    private fun init(view: View){

        tvData = view.findViewById(R.id.tv_message)

        tvData.text = homeViewModel.someData
    }
    private fun getDependencies(){

        DaggerFragmentComponent.builder()
            .applicationComponent((context!!.applicationContext as MyApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()
            .inject(this)
        Log.d("DEBUG", "${homeViewModel.someData}")
    }

}