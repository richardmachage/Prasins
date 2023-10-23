package com.example.prasins.presentation.navigation

sealed class NavRoutes(val route:String){
    object HomeScreen : NavRoutes("home_screen")
    object LoginScreen : NavRoutes("log_in_screen")
    object SignupScreen : NavRoutes("sign_up_screen")
    object MainScreen : NavRoutes("main_screen")
    object PaymentScreen : NavRoutes("payment_screen")
    object AccountScreen : NavRoutes("account_screen")
}
