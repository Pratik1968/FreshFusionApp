package com.pratikshekhar.myproject.freshfusion.presentation.screens.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.presentation.screens.order.composables.Header
import com.pratikshekhar.myproject.freshfusion.presentation.screens.order.composables.OrderList

@Preview(showBackground = true)
@Composable
fun OrderScreen(modifier: Modifier=Modifier){
Column(
    modifier

        .fillMaxSize()
        .padding(start = 18.dp, end = 18.dp, top = 24.dp)
) {
    Header()
    Spacer(modifier = Modifier.height(24.dp))
    OrderList()
}
}