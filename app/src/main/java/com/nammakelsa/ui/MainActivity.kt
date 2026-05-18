package com.nammakelsa.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.nammakelsa.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

            val navController = navHostFragment.navController
            val graph = navController.navInflater.inflate(R.navigation.nav_graph)

            // If user is already signed in, skip the auth flow and go straight to home
            if (firebaseAuth.currentUser != null) {
                graph.setStartDestination(R.id.workerHomeFragment)
            } else {
                graph.setStartDestination(R.id.phoneEntryFragment)
            }

            navController.graph = graph
        }
    }
}
