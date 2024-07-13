package com.pratikshekhar.myproject.freshfusion.presentation.screens.order.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.LightGrey
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun OrderListItem(@DrawableRes image:Int= R.drawable.veg_1, contentDescription:String="orderListItem",title:String="Basket#1",price:String="Rs 100",date:String="20/05/24"){
    Row (
        Modifier
            .fillMaxWidth()
            .height(62.dp)
            .padding(start = 6.dp, end = 6.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,

    ){
Image(painter = painterResource(id = image), contentDescription = contentDescription)
Spacer(modifier = Modifier.width(8.dp))
        Info(title,price)
        Spacer(modifier = Modifier.weight(1f))
        DateText(date)

    }

}

@Composable
private fun DateText(date: String) {
Text(date, style = Typography.bodyMedium.copy(color = LightGrey,))
}

@Composable
private fun Info(title:String="Basket#1",price:String){
Column {

    Text(title, style = Typography.bodyMedium.copy(color = Dark, fontWeight = FontWeight.Bold))
    Text(price, style = Typography.bodyMedium.copy(color = Dark, fontWeight = FontWeight.Medium))
}

}