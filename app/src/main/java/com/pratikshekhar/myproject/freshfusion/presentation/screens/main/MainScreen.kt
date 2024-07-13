package com.pratikshekhar.myproject.freshfusion.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.presentation.screens.catergories.CategoriesScreen
import com.pratikshekhar.myproject.freshfusion.presentation.screens.home.HomeScreen
import com.pratikshekhar.myproject.freshfusion.presentation.screens.main.composables.BottomNav
import com.pratikshekhar.myproject.freshfusion.presentation.screens.order.OrderScreen
import com.pratikshekhar.myproject.freshfusion.presentation.screens.profile.ProfileScreen


@Preview(showBackground = true)
@Composable
fun MainScreen(){
    var currentScreen by remember{
        mutableStateOf<Routes>(Routes.HOME)
    }
    val updateCurrentScreen = fun(value:Routes){
currentScreen = value
    }
    Box(
        Modifier
            .fillMaxSize()
           ) {
Body(currentScreen = currentScreen)
        BottomNav(Modifier.align(Alignment.BottomCenter),updateCurrentScreen,currentScreen)

    }
}
@Composable

private  fun Body(currentScreen: Routes){
    Column(Modifier.fillMaxSize()) {
        GetCurrentScreen(currentScreen = currentScreen)


    }
}
@Composable
private  fun GetCurrentScreen(currentScreen:Routes){
 when(currentScreen){
    Routes.HOME-> HomeScreen(Modifier.padding(bottom=60.dp))
    Routes.ORDERS->OrderScreen(Modifier.padding(bottom=60.dp))
    Routes.CATEGORIES-> CategoriesScreen(Modifier.padding(bottom=60.dp))
    Routes.PROFILE -> ProfileScreen(Modifier.padding(bottom=60.dp))
    else -> HomeScreen(Modifier.padding(bottom=60.dp))
}
}
enum class Routes{
    HOME,
    CATEGORIES,
    ORDERS,
    PROFILE
}

