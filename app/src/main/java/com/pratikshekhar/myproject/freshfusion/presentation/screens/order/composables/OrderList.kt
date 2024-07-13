package com.pratikshekhar.myproject.freshfusion.presentation.screens.order.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun OrderList(

){
Column(
    Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .verticalScroll(rememberScrollState())


) {

    repeat(10){

OrderListItem()
    }

}

}