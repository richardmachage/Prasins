package com.example.prasins.presentation.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Payment
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prasins.presentation.navigation.NavRoutes
import com.example.prasins.presentation.screens.mainscreen.AccountScreen.AccountScreen
import com.example.prasins.presentation.screens.mainscreen.homescreen.HomeScreen
import com.example.prasins.presentation.screens.mainscreen.payment.PaymentScreen

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    var navHostController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                MyBottomNavigationBar(navItems = setNavItems(), navHostController)
            }
        ) {
           NavHost(
               navController = navHostController,
               startDestination = NavRoutes.HomeScreen.route){
               composable(NavRoutes.HomeScreen.route){ HomeScreen()}
               composable(NavRoutes.PaymentScreen.route){ PaymentScreen()}
               composable(NavRoutes.AccountScreen.route){ AccountScreen() }
           }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomNavigationBar(navItems: List<BottomNavigationItem>, navController: NavController) {
    var selectedItemIndex by remember {
        mutableStateOf(value = 0)
    }
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    when (item.title) {
                        "Home" -> navController.navigate(NavRoutes.HomeScreen.route)
                        "Payments" -> navController.navigate(NavRoutes.PaymentScreen.route)
                        "Account" -> navController.navigate(NavRoutes.AccountScreen.route)
                    }
                    //TODO("Add Navigation code here as well")

                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }) {
                        Icon(
                            if (selectedItemIndex == index) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            contentDescription = item.title
                        )
                    }
                },
                label = {
                    Text(text = item.title)
                })
        }


    }
}

fun setNavItems(): List<BottomNavigationItem> {
    return listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Payments",
            selectedIcon = Icons.Filled.Payment,
            unselectedIcon = Icons.Outlined.Payment,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Account",
            selectedIcon = Icons.Filled.AccountBox,
            unselectedIcon = Icons.Outlined.AccountBox,
            hasNews = false,
        ),
    )

}
