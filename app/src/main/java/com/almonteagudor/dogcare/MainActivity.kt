package com.almonteagudor.dogcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.almonteagudor.dogcare.presentation.medicines.AddMedicineScreen
import com.almonteagudor.dogcare.presentation.medicines.MedicineScreen
import com.almonteagudor.dogcare.ui.theme.DogcareTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogcareTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "medicine_list"
                ) {
                    composable("medicine_list") {
                        MedicineScreen(onAddMedicineClick = {
                            navController.navigate("add_medicine")
                        })
                    }
                    composable("add_medicine") {
                        AddMedicineScreen(
                            onMedicineAdded = { navController.navigate("medicine_list") },
                            onError = { errorMessage -> }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogcareTheme {
        Greeting("Android")
    }
}