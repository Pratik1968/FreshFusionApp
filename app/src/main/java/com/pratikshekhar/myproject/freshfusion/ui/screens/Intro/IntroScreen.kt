package com.pratikshekhar.myproject.freshfusion.ui.screens.Intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pratikshekhar.myproject.freshfusion.ProjectNavigationController
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.MediumButton
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingHorizontal
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingVertical
import com.pratikshekhar.myproject.freshfusion.ui.theme.Dark
import com.pratikshekhar.myproject.freshfusion.ui.theme.LightGrey
import com.pratikshekhar.myproject.freshfusion.ui.theme.Primary
import com.pratikshekhar.myproject.freshfusion.ui.theme.Typography
import com.pratikshekhar.myproject.freshfusion.util.NavDestination
import com.pratikshekhar.myproject.freshfusion.util.SetStatusBarColor
import com.pratikshekhar.myproject.freshfusion.util.SetThemeBar

@Preview(showBackground = true)
@Composable
private fun Preview(){
    RootLayout()
}
@Composable
fun IntroScreen(){
    val nav = ProjectNavigationController.current
    SetStatusBarColor(color = Color.White)
SetThemeBar(value = true)
RootLayout(nav = nav)
}
@Composable
private  fun RootLayout(nav:NavHostController=NavHostController(LocalView.current.context)){


    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
Leaf3(Modifier.align(Alignment.TopEnd))
        Leaf2(Modifier.align(Alignment.CenterEnd))
        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .wrapContentHeight()
                .wrapContentHeight(),

            ){

            Background(Modifier.align(Alignment.BottomCenter))
Leaf1()
        }
        Container(Modifier,nav)
    }
}

@Composable
private fun Background(modifier: Modifier=Modifier){
Image(painter = painterResource(id = R.drawable.intro_screeen_background),modifier=modifier.fillMaxWidth(), contentDescription = "background", contentScale = ContentScale.FillWidth)

}
@Composable
private fun Leaf1(modifier: Modifier=Modifier){
    Image(painter = painterResource(id = R.drawable.leaf1),modifier=modifier.size(50.dp), contentDescription = "leaf1")


}
@Composable
private fun Leaf2(modifier: Modifier=Modifier){
    Image(painter = painterResource(id = R.drawable.leaf2),modifier=modifier.size(50.dp), contentDescription = "leaf2", alignment = Alignment.TopEnd )

}
@Composable
private fun Leaf3(modifier: Modifier=Modifier){
    Image(painter = painterResource(id = R.drawable.leaf3),modifier=modifier.size(50.dp), contentDescription = "leaf3" )

}

@Composable
private fun Container(modifier: Modifier =Modifier,nav: NavHostController){
    Column(modifier.padding(vertical = ContentPaddingVertical, horizontal = ContentPaddingHorizontal),
horizontalAlignment = Alignment.CenterHorizontally,
        ) {
Logo()
        Spacer(modifier = Modifier.height(32.dp))
        Title()
        Spacer(modifier = Modifier.height(24.dp))
        Tagline()
        Spacer(modifier = Modifier.height(40.dp))
        ShopNowButton(nav
        )
    }
}
@Composable
private  fun Logo(modifier: Modifier=Modifier){
    Image(painter = painterResource(id = R.drawable.logo),modifier=modifier.size(80.dp), contentDescription = "leaf3" )

}
@Composable
fun Title(){
Text("Get your groceries delivered to your home",
color = Dark,
  style = Typography.titleLarge,
    textAlign = TextAlign.Center

    )
}
@Composable
fun Tagline(){
    Text(
        "The best delivery app in town for delivering your daily fresh groceries",
        color= LightGrey,
      style = Typography.bodyMedium,
textAlign = TextAlign.Center
    )
}
@Composable
fun ShopNowButton(nav:NavHostController){
    var changeRoute by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = changeRoute) {
        if(changeRoute){
nav.navigate(NavDestination.LOGIN_SCREEN)
        }
    }

    MediumButton(text = "Shop Now", colors = ButtonDefaults.buttonColors(Primary),onClick = { changeRoute = true })
}
