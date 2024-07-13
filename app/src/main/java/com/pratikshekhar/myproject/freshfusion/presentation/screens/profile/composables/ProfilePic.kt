package com.pratikshekhar.myproject.freshfusion.presentation.screens.profile.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R

@Preview(showBackground = true)
@Composable
fun ProfilePic(@DrawableRes image:Int= R.drawable.profile){
Image(modifier = Modifier.size(100.dp),painter = painterResource(id =image ), contentDescription ="Profile picture" )
}