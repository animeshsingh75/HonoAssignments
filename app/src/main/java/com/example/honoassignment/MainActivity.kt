package com.example.honoassignment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.honoassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf(
            MainActivityModel("Assignment 1"),
            MainActivityModel("Assignment 2")
        )
        val adapter = MainActivityAdapter(list, this)
        binding.assignmentRv.apply {
            setAdapter(adapter)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }

    override fun onItemClicked(assignmentName: String) {
        binding.navigationHost.visibility = View.VISIBLE
        binding.assignmentRv.visibility = View.GONE
        val navHostFragment =
            binding.navigationHost as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.navigation)

        when (assignmentName) {
            "Assignment 1" -> {
                R.id.firstFragment
            }
            "Assignment 2"->{
                R.id.apiFragment
            }
        }
        navController.graph = navGraph
    }
}