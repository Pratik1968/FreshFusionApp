package com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun CategoriesSection(modifier: Modifier = Modifier){
    Column(modifier) {
        Title()
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),) {
CategoriesItem(Modifier.weight(1f), R.drawable.apple_illustration,"fruit","Fruit")
    CategoriesItem(Modifier.weight(1f),R.drawable.broccoli_illustration,"vegetable","Vegetable")
    CategoriesItem(Modifier.weight(1f),R.drawable.cheese_illustration,"diary","Diary")
    CategoriesItem(Modifier.weight(1f),R.drawable.meat_illustration,"meat","Meat")

}
    }
}
@Composable
private fun Title(){
    Text("Categories ",style = Typography.bodyMedium.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Dark))
}