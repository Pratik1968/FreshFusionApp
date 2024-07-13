package com.pratikshekhar.myproject.freshfusion.presentation.screens.catergories.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun Header(){
    Box(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
contentAlignment = Alignment.Center
        ){
Text(
    text = "Categories",
    style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold, color = Dark, fontSize = 20.sp)
)
    }
}
