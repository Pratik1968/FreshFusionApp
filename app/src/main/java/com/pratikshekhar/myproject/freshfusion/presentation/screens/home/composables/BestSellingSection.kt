package com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun BestSellingSection(modifier: Modifier=Modifier){
    val products = (1..10).map { it.toString() }
Column(
    modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(18.dp)

) {
Title()
    Spacer(modifier = Modifier.height(16.dp))

    Column(
    Modifier
        .fillMaxWidth()
        .wrapContentHeight()
){
    repeat(5)
    {
        Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround) {

        BestSellingProductItem()
        BestSellingProductItem()


    }
    }
}

}
}

@Composable
private fun Title(){
    Text("Best Selling ",style = Typography.bodyMedium.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Dark))
}
