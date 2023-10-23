package com.example.prasins

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.prasins.presentation.navigation.SetupNavGraph
import com.example.prasins.ui.theme.PrasinsTheme



class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            
            PrasinsTheme() {

                    var navHostController = rememberNavController()
                    SetupNavGraph(navHostController = navHostController)

            }
        }
    }
}


