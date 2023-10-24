package com.example.prasins.presentation.screens.signupscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prasins.presentation.screens.loginscreen.EditText
import com.example.prasins.presentation.screens.loginscreen.PasswordEditText

@Composable
fun SignupScreen(navHostController: NavHostController){
    //var navHostController = rememberNavController()
    Surface(
        modifier=Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            IconButton(onClick = { /*TODO*/
                navHostController.popBackStack()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Arrow Back")
            }

            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                EditText( // User ID input
                    label = "Enter your User ID",
                    hint = "user ID",
                    iconLeading = Icons.Filled.AccountBox,
                    iconLeadingDescription = "AccountBox Icon",
                    keyboardType = KeyboardType.Text
                )

                EditText( //Email Input
                    label = "Enter your Email",
                    hint = "Email",
                    iconLeading = Icons.Default.Email ,
                    iconLeadingDescription = "Email icon",
                    keyboardType = KeyboardType.Email
                )

                PasswordEditText( //Password Input
                    label = "Enter your Password",
                    hint = "Password",
                    iconLeading = Icons.Default.Lock ,
                    iconLeadingDescription = "Lock Icon",
                    keyboardType = KeyboardType.Password
                )

                PasswordEditText( //Confirm Password Input
                    label = "Confirm your Password",
                    hint = "Confirm Password",
                    iconLeading = Icons.Default.Lock ,
                    iconLeadingDescription = "Lock Icon",
                    keyboardType = KeyboardType.Password
                )

                Button( //Sign up Button
                    onClick = {
                              //TODO perform sign up and navigate to log in
                              navHostController.popBackStack()
                              },
                    modifier = Modifier
                        .padding(
                            start = (10.dp),
                            end = (10.dp),
                            top = (20.dp)
                        )
                        .fillMaxWidth()
                    ) {
                    Text(text = "Sign Up")
                }

            }
        }
    }
}


