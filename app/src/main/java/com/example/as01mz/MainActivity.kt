package com.example.as01mz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.as01mz.ui.theme.AS01MZTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AS01MZTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.systemBars),
//                    topBar = {
//                        TopAppBar(
//                            title = {
//                                Text(
//                                    text = "AvatarApp",
//                                    style = MaterialTheme.typography.titleLarge
//                                )
//                            },
//                            colors = TopAppBarDefaults.topAppBarColors(
//                                containerColor = Color(0xFFC2185B),
//                                titleContentColor = Color.White
//                            )
//                        )
//                    }
                ) { innerPadding ->
                    AppNav(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppNav(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Reg // data object langsung
    ) {
        composable<Reg> {
            FRegister(
                modifier = Modifier,
                onNavigateToLogin = {
                    navController.navigate(Log)
                }
            )
        }

        composable<Log> {
            FLogin(
                modifier = Modifier,
                onBack = {
                    navController.popBackStack()
                },
                onNavigateToProfil = {
                    navController.navigate(Prof)
                }
            )
        }

        // Layar Profile
        composable<Prof> {
            FProfil(
                modifier = Modifier,
                onBack = {
                    navController.popBackStack()
                },
                onNavigateToAvatar = {
                    navController.navigate(Avt)
                }
            )
        }

        composable<Avt> {
            FAvatar(
                modifier = Modifier,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}