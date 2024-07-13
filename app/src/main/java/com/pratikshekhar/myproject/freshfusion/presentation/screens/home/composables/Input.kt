package com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.screens.composables.BasicInput

@Preview(showBackground = true)
@Composable
fun Input(modifier: Modifier=Modifier) {
val value by remember{
    mutableStateOf<String>("Search Catergories")
}
    Row(
    modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(67.dp))
        .background(Color.White)
        .padding(20.dp)


    ){
Image(painter = painterResource(id = R.drawable.ic_search), contentDescription ="search" )
Spacer(modifier = Modifier.width(8.dp))
    BasicInput(placeholder = value, onValueChange = {

    })
}
}