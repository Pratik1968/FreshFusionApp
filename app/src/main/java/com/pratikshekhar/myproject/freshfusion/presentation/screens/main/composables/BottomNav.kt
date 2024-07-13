package com.pratikshekhar.myproject.freshfusion.presentation.screens.main.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.screens.main.Routes
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.LightGrey
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Primary

@Preview(showBackground = true)
@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    updateCurrentScreen: (Routes) -> Unit = {},
    currentScreen: Routes = Routes.HOME
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier
            .fillMaxWidth()
            .height(80.dp),
    ) {

        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.White)
                .fillMaxHeight(0.8f)
                .padding(start = 18.dp, end = 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_home), contentDescription = "home",
colorFilter = ColorFilter.tint(if(currentScreen==Routes.HOME) Dark else LightGrey),
                modifier = Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    updateCurrentScreen(Routes.HOME)
                }
                )
            Image(
                painter = painterResource(id = R.drawable.ic_categories),
                contentDescription = "categories",
                colorFilter = ColorFilter.tint(if(currentScreen==Routes.CATEGORIES) Dark else LightGrey),
                        modifier = Modifier.clickable(     interactionSource = interactionSource,
                            indication = null) {
                    updateCurrentScreen(Routes.CATEGORIES)
                }
            )
            Spacer(modifier = Modifier.width(24.dp))
            Image(painter = painterResource(id = R.drawable.ic_order), contentDescription = "order",
                colorFilter = ColorFilter.tint(if(currentScreen==Routes.ORDERS) Dark else LightGrey),
                modifier = Modifier.clickable(     interactionSource = interactionSource,
                    indication = null) {
                    updateCurrentScreen(Routes.ORDERS)
                }

            )
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "profile",
                colorFilter = ColorFilter.tint(if(currentScreen==Routes.PROFILE) Dark else LightGrey),
                modifier = Modifier.clickable(     interactionSource = interactionSource,
                    indication = null) {
                    updateCurrentScreen(Routes.PROFILE)
                }

            )

        }
        CartButton(Modifier.align(Alignment.TopCenter))


    }
}


@Composable
private fun CartButton(modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(Primary, shape = RoundedCornerShape(100.dp))
            .size(44.dp),

        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "cart")

    }

}

