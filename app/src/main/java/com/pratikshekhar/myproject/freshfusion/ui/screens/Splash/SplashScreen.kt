package com.pratikshekhar.myproject.freshfusion.ui.screens.Splash

import android.window.SplashScreen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pratikshekhar.myproject.freshfusion.ProjectNavigationController
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.ui.theme.Primary
import com.pratikshekhar.myproject.freshfusion.util.NavDestination
import com.pratikshekhar.myproject.freshfusion.util.SetStatusBarColor

@Preview(showBackground = true)
@Composable
private fun Preview(){
RootLayout()
}
@Composable
fun SplashScreen(){
    SetStatusBarColor(color = Primary)
RootLayout()
}
@Composable
private fun  RootLayout(){
    Column(
        Modifier
            .fillMaxSize()
            .background(Primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimationContainer()
    }
}
@Composable
private  fun AnimationContainer(){

    val visible = remember { MutableTransitionState(false).apply { targetState=true } }
    AnimatedVisibility(visibleState = visible,

        exit = fadeOut(
            animationSpec = tween(durationMillis = 5000)
        )
    ) {
        Logo()
        when{
            visible.isIdle && visible.currentState->{
              ProjectNavigationController.current.navigate(NavDestination.INTRO_SCREEN)
            }
        }
    }
}
@Composable
private fun Logo(){
    Image(painter = painterResource(id = R.drawable.logo)
        , contentDescription = "logo")
}