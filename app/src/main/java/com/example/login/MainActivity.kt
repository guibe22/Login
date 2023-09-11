package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.login.login.LoginContentScreen
import com.example.login.ui.theme.LoginTheme
import com.example.login.util.InicioScreen
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     val navController = rememberNavController()
                    NavHost(navController, startDestination = "loginScreen") {
                        composable("loginScreen") {
                            LoginContentScreen(
                                loginViewModel = hiltViewModel(),
                                onRegisterNavigateTo = {

                                    navController.navigate("inicioScreen")
                                }
                            )
                        }

                        composable("inicioScreen") {
                            InicioScreen()
                        }
                    }


                }
            }
        }
    }
}
@Composable
fun Navegar(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = "loginScreen") {
        composable("loginScreen") {
            LoginContentScreen(
                loginViewModel = hiltViewModel(),
                onRegisterNavigateTo = {
                    navController.navigate("inicioScreen")
                }
            )
        }

        composable("inicioScreen") {
            InicioScreen()
        }
}
}

