package com.pratikshekhar.myproject.freshfusion.presentation.screens.catergories.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.LightGrey2
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun CategoryCard(modifier: Modifier=Modifier,@DrawableRes image:Int = R.drawable.apple_illustration,contentDescription:String="fruit",title:String="Fruit"){
    Column (
        modifier
            .height(241.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(LightGrey2)

        ,
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Image(modifier = Modifier.fillMaxWidth(.8f).fillMaxHeight(0.8f),painter = painterResource(id =image ), contentDescription =contentDescription, contentScale = ContentScale.Fit )
Text(title, style = Typography.bodyMedium.copy(color = Dark, fontWeight = FontWeight.Bold, fontSize = 20.sp))
    }

}