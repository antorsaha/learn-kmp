package com.saha.testapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saha.testapplication.navigation.AppRoute
import com.saha.testapplication.screens.HomeScreen
import com.saha.testapplication.screens.SecondScreen
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Suppress("DEPRECATION")
@Composable
fun App() {

    val batteryManager = koinInject<BatteryManager>()
    KoinContext {
        MaterialTheme {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = AppRoute.Home,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(AppRoute.Home) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        HomeScreen(
                            batteryManager = batteryManager,
                            onOpenSecond = { navController.navigate(AppRoute.Second) }
                        )
                    }
                }
                composable(AppRoute.Second) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        SecondScreen(onBack = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}
