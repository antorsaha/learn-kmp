package com.saha.testapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saha.testapplication.BatteryManager
import com.saha.testapplication.dependencies.MyViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import testapplication.composeapp.generated.resources.Res
import testapplication.composeapp.generated.resources.crown

@Composable
fun HomeScreen(
    batteryManager: BatteryManager,
    onOpenSecond: () -> Unit,
    viewModel: MyViewModel = koinViewModel(),
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = viewModel.getHelloWorldString())

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Battery level is ${batteryManager.getBatteryLevel()}")

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(Res.drawable.crown),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onOpenSecond) {
            Text("Go to second screen")
        }
    }
}
