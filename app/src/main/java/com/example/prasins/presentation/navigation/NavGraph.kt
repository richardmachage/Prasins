package com.example.prasins.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.prasins.presentation.screens.loginscreen.LogInScreen
import com.example.prasins.presentation.screens.mainscreen.MainScreen
import com.example.prasins.presentation.screens.signupscreen.SignupScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoutes.LoginScreen.route
    ) {
           // composable(route=NavRoutes.HomeScreen.route){ HomeScreen() }
            composable(route=NavRoutes.LoginScreen.route){ LogInScreen(navHostController) }
            composable(route=NavRoutes.SignupScreen.route){ SignupScreen(navHostController) }
            composable(route=NavRoutes.MainScreen.route){ MainScreen() }
        }
    }
