package com.pratikshekhar.myproject.freshfusion.presentation.screens.catergories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.screens.catergories.composables.CategoryCard
import com.pratikshekhar.myproject.freshfusion.presentation.screens.catergories.composables.Header

@Preview(showBackground = true)
@Composable
fun CategoriesScreen(modifier: Modifier=Modifier){
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 18.dp, end = 18.dp, top = 24.dp)
    ) {
Header()
        Spacer(Modifier.height(30.dp))
Grid()
    }

}
@Composable
private fun Grid(){
Column(Modifier.fillMaxSize(), ) {
    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
CategoryCard(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(10.dp))
        CategoryCard(modifier = Modifier.weight(1f),image=R.drawable.broccoli_illustration, contentDescription = "vegetable", title = "Vegetable")

    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
        CategoryCard(modifier = Modifier.weight(1f),image=R.drawable.cheese_illustration, contentDescription = "diary", title = "Diary")
        Spacer(modifier = Modifier.width(10.dp))

        CategoryCard(modifier = Modifier.weight(1f),image=R.drawable.meat_illustration, contentDescription = "meat", title = "Meat")

    }
}
}
