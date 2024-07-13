package com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Primary
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Red
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun BestSellingProductItem(modifier: Modifier=Modifier) {
    Column(
        modifier
            .height(241.dp)
            .width(163.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(LightGrey2)

    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .weight(0.7f),
            painter = painterResource(id = R.drawable.veg_1),
            contentDescription = "content",
            contentScale = ContentScale.Fit
        )
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = "Bell Pepper Red",
            style = Typography.bodyMedium.copy(
                color = Dark,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
Container()
    }
}

@Composable
private fun Container(){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
    ) {

        Text(
            text = "1kg,Rs 10",
            style = Typography.bodyMedium.copy(color = Red, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.weight(1f))
        AddButton()
    }
}

@Composable
private fun AddButton() {
    Box(
        Modifier
            .size(36.dp)
            .clip(RoundedCornerShape(100))
            .background(Primary),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.add), contentDescription = "add")
    }
}