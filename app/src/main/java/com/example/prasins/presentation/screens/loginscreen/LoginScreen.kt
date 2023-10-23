package com.example.prasins.presentation.screens.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.prasins.R
import com.example.prasins.R.mipmap.logo_prasins
import com.example.prasins.presentation.navigation.NavRoutes

@Composable
fun LogInScreen(navHostController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter= painterResource(id = R.mipmap.img),
                contentDescription= "Prasins_logo",
                modifier=Modifier
                    //.size(128.dp)
                    .clip(CircleShape)
                   // .border(10.dp, color = MaterialTheme.colorScheme.outline, CircleShape)
            )

            EditText( //Email Input
                label = "Enter your Email",
                hint = "Email",
                iconLeading = Icons.Default.Email,
                iconLeadingDescription = "Email icon",
                keyboardType = KeyboardType.Email
            )

            PasswordEditText(
                label = "Enter your password",
                hint = "Password",
                iconLeading = Icons.Default.Lock,
                iconLeadingDescription = "Password Icon",
                keyboardType = KeyboardType.Password
            )

            TextButton( //forgot password button
                modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.Start),
                onClick = { /*TODO*/ }) {
                Column {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start),
                        text = "Forgot Password?",
                        fontStyle = FontStyle.Italic
                    )
                }
            }


            Button( // Log In Button
                onClick = {
                          navHostController.navigate(NavRoutes.MainScreen.route)
                },
                modifier = Modifier
                    .padding(
                        start = (10.dp),
                        end = (10.dp),
                        top = (20.dp)
                    )
                    .fillMaxWidth()
            ) {
                Text(text = "Log In")
            }


            TextButton( // Sign Up Button
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.Start),
                onClick = {
                    //TODO navigate to sign up
                    navHostController.navigate(NavRoutes.SignupScreen.route)
                }
            ) {
                Column() {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start),
                        text = "You don't have an account? Sing Up",
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(
    label: String,
    hint: String,
    iconLeading: ImageVector,
    iconLeadingDescription: String,
    keyboardType: KeyboardType
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = (10.dp), end = (10.dp)),
        value = text,
        label = { Text(text = label) },
        placeholder = { Text(text = hint) },
        onValueChange = { newText -> text = newText },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        leadingIcon = {
            Icon(
                imageVector = iconLeading,
                contentDescription = iconLeadingDescription
            )
        },
        trailingIcon = {
            IconButton(onClick = { text = TextFieldValue("") }) {
                Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear_input")
            }
        },
        singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordEditText(
    label: String,
    hint: String,
    iconLeading: ImageVector,
    iconLeadingDescription: String,
    keyboardType: KeyboardType
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var showPassword by remember { mutableStateOf(value = false) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = (10.dp), end = (10.dp)),
        value = text,
        label = { Text(label) },
        placeholder = { Text(hint) },
        onValueChange = { newText -> text = newText },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        leadingIcon = {
            Icon(
                imageVector = iconLeading,
                contentDescription = iconLeadingDescription
            )
        },
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide_password"
                    )
                }
            } else {
                IconButton(onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "show_password"
                    )
                }
            }
        },
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        singleLine = true

    )

}

@Preview
@Composable
fun PreviewLogIn(){
    LogInScreen(navHostController = rememberNavController())
}