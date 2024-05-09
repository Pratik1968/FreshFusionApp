package com.pratikshekhar.myproject.freshfusion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pratikshekhar.myproject.freshfusion.ui.screens.Intro.IntroScreen
import com.pratikshekhar.myproject.freshfusion.ui.screens.Login.Composables.LoginScreen
import com.pratikshekhar.myproject.freshfusion.ui.screens.Splash.SplashScreen
import com.pratikshekhar.myproject.freshfusion.ui.theme.FreshFusionTheme
import com.pratikshekhar.myproject.freshfusion.util.NavDestination
import dagger.hilt.android.AndroidEntryPoint
@SuppressLint("CompositionLocalNaming")
val ProjectNavigationController = compositionLocalOf<NavHostController> { error("LocalNavigationController not found") }
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreshFusionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {

                  NavigationSetting()
                }
            }
        }
    }
}

@Composable
fun NavigationSetting()
{
    val navController = rememberNavController()
   CompositionLocalProvider(ProjectNavigationController provides  navController) {
        NavHost(navController = navController, startDestination = NavDestination.SPLASH_SCREEN) {

            composable(NavDestination.SPLASH_SCREEN) {
                SplashScreen()
            }
            composable(NavDestination.INTRO_SCREEN) {
IntroScreen()
            }
            composable(NavDestination.LOGIN_SCREEN) {
                LoginScreen()
            }
        }
    }
}

