package com.pratikshekhar.myproject.freshfusion.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables.AdBannerSection
import com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables.BestSellingSection
import com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables.CategoriesSection
import com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables.Header
import com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables.Input

@Preview(showBackground = true)
@Composable
fun HomeScreen(modifier: Modifier =Modifier){
    Box(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        Image(
            painter = painterResource(id = R.drawable.home_background),
            contentDescription = "background"
        )
Body()
    }
}
@Composable
private fun Body(){
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                focusManager.clearFocus()

            }

    ) {
    Spacer(modifier = Modifier.height(5.dp))
    Header(Modifier.padding(horizontal = 18.dp))
   Spacer(modifier = Modifier.height(18.dp))
    Input(Modifier.padding(horizontal = 18.dp))
       Spacer(modifier = Modifier.height(24.dp))
        AdBannerSection()
       Spacer(modifier = Modifier.height(24.dp))
        CategoriesSection(Modifier.padding(horizontal = 18.dp))
        Spacer(modifier = Modifier.height(24.dp))
        BestSellingSection()}
}

