package com.example.plutoclonecom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MaterialTheme {
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomeScreen(
                            onNavigateToDemand = {
                                if (navController.currentBackStackEntry?.destination?.route != "demand") {
                                    navController.navigate("demand") {
                                        popUpTo("home") { inclusive = true }
                                    }
                                }
                            },
                            onNavigateToHome = {}
                        )
                    }

                    composable("demand") {
                        Demand(
                            onNavigateToDemand = {},
                            onNavigateToHome = {
                                if (navController.currentBackStackEntry?.destination?.route != "home") {
                                    navController.navigate("home") {
                                        popUpTo("demand") { inclusive = true }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}