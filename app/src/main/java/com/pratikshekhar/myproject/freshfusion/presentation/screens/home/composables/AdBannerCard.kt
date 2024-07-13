package com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.theme.DarkGreen
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun AdBannerCard(modifier: Modifier=Modifier){
    Box(
        modifier
            .height(158.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
    ){
Image(painter = painterResource(id = R.drawable.banner), contentDescription ="Ad Banner",Modifier.fillMaxHeight(), contentScale = ContentScale.FillHeight )
Info(Modifier.align(Alignment.BottomEnd))
    }
}
@Composable
private fun Info(modifier: Modifier=Modifier){
    Box(modifier = modifier.fillMaxWidth(0.5f), contentAlignment = Alignment.TopEnd){
        Image(painter = painterResource(id = R.drawable.ad_banner_background), contentDescription ="Ad Banner Background", contentScale = ContentScale.FillWidth )

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text("Diwali Offer", style = Typography.bodyMedium.copy(fontSize = 12.sp,))
            Text(text = "Get 25%", style = Typography.bodyMedium.copy(fontSize = 28.sp))
            OfferButton()
        }
    }
}
@Composable
private fun  OfferButton(){
Row(
    Modifier
        .wrapContentWidth()
        .clip(RoundedCornerShape(15.dp))
        .background(Color.White)
        .padding(horizontal = 8.dp, vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically
) {
Text("Grab Offer", style = Typography.bodyMedium.copy(fontSize = 12.sp, color = DarkGreen))
    Spacer(modifier = Modifier.width(5.dp))
Image(painter = painterResource(id = R.drawable.right), contentDescription ="right arrow" )
}
}