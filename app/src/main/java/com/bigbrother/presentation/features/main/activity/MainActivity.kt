package com.bigbrother.presentation.features.main.activity

import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.bigbrother.R
import com.bigbrother.databinding.ActivityMainBinding
import com.bigbrother.presentation.base.BaseActivity
import com.bigbrother.presentation.common.OnProjectClickListener
import com.bigbrother.presentation.features.projects.fragment.ProjectsFragmentDirections
import com.bigbrother.presentation.features.projects.model.ProjectVO

class MainActivity : BaseActivity<ActivityMainBinding>(), OnProjectClickListener {

    private lateinit var navController: NavController


    override fun init() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

    override fun inflate(inflater: LayoutInflater) = ActivityMainBinding.inflate(inflater)

    //Listeners
    override fun onProjectClick(project: ProjectVO) {
        val direction =
            ProjectsFragmentDirections.actionProjectsFragmentToProjectBoardFragment(project)
        navController.navigate(direction)
    }
}