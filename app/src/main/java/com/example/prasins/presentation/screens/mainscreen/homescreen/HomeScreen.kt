package com.example.prasins.presentation.screens.mainscreen.homescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier=Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceTint
    ) {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Home")
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ })
                        {
                            Icon(imageVector= Icons.Default.AccountCircle, contentDescription ="Account Icon" )
                        }
                        IconButton(onClick = { /*TODO*/ })
                        {
                            Icon(imageVector = Icons.Default.Settings, contentDescription ="Settings Icon")
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { paddingValue ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValue)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                //ToggleButton(name = "Switch Drier On/Off")

                SwitchCard(modifier = Modifier.fillMaxWidth())
                MyTemperatureCard(modifier = Modifier.fillMaxWidth())
                MoistureCard(modifier = Modifier.fillMaxWidth())
                ProductCard(modifier = Modifier.fillMaxWidth())


            }
        }

    }
}

@Composable
fun ProductCard(modifier: Modifier) {
    Card(
        modifier = modifier            .padding(16.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = MaterialTheme.shapes.medium
    ) {

        Text(
            modifier = Modifier.padding(10.dp),
            text = "Product Drying",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.bodyLarge,
            text = "Maindi"
        )
    }
}

@Composable
fun SwitchCard(modifier: Modifier) {
    Card(
       modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {

        Text(
            modifier = Modifier.padding(10.dp),
            text = "Drier Status",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary

        )
        Spacer(modifier = Modifier.height(8.dp))

        ToggleButton(name = "Power Control")

    }
}

@Composable
fun MoistureCard(modifier: Modifier) {
    Card(
        modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Moisture Reading",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(10.dp),
            text = "60%",
            style = MaterialTheme.typography.bodyLarge
        )
    }

}

@Composable
fun MyTemperatureCard(
    modifier: Modifier
) {
    Card(
        modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium,
    ) {
        var temperature = 1
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Temperature",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary

        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconButton(
                modifier = Modifier
                    .padding(5.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Remove, contentDescription = "Remove Icon")
            }

            Text(text = temperature.toString(), style = MaterialTheme.typography.bodyLarge)

            IconButton(
                modifier = Modifier
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
