package com.example.prasins.presentation.screens.mainscreen.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //ToggleButton(name = "Switch Drier On/Off")

            SwitchCard(modifier = Modifier.fillMaxWidth())
            MyTemperatureCard(modifier = Modifier.fillMaxWidth())
            MoistureCard(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun SwitchCard(modifier: Modifier){
    Card(modifier = modifier.padding(16.dp),
        elevation= CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium) {

        Text(
            modifier=Modifier.padding(10.dp),
            text = "Drier Status",
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        ToggleButton(name = "Power Control")

    }
}

@Composable
fun MoistureCard(modifier: Modifier){
    Card (
        modifier = modifier.padding(16.dp),
        elevation= CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium
    ){
        Text(
            modifier=Modifier.padding(10.dp),
            text = "Moisture Reading",
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier=Modifier.padding(10.dp),
            text = "60%",
            style= MaterialTheme.typography.bodyLarge
            )
    }

}
@Composable
fun MyTemperatureCard(
    modifier: Modifier
) {
    Card(
        modifier = modifier.padding(16.dp),
        elevation= CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium,
    ) {
        var temperature = 1
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Temperature",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconButton(
                modifier=Modifier
                .padding(5.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Remove, contentDescription = "Remove Icon")
            }

            Text(text = temperature.toString(), style = MaterialTheme.typography.bodyLarge)

            IconButton(
                modifier=Modifier
                    .padding(5.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Remove Icon")
            }

        }
    }
}

@Composable
fun ToggleButton(
    name: String
) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        //modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = name,
            style = MaterialTheme.typography.bodyLarge
        )

        Switch(
            checked = isChecked,
            onCheckedChange = { state -> isChecked = state })
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyHomePreview() {
    HomeScreen()
}