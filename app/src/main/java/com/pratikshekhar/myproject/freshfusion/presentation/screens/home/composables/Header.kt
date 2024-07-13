package com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.LightGrey
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun Header(modifier: Modifier =Modifier) {
    return Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Transparent)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Profile()
        Spacer(modifier = Modifier.width(3.dp))
        Info()
        Spacer(Modifier.weight(1f))
        AddressTag()
    }
}

@Composable
private fun Info() {
    return Column {
        Text(
            text = "Good Morning",
            style = Typography.labelMedium.copy(color = LightGrey, fontSize = 12.sp)
        )
        Text(
            text = "Amelia Barlow",
            style = Typography.bodyMedium.copy(color = Dark, fontSize = 16.sp)
        )
    }
}

@Composable
private fun Profile() {
    return Box(Modifier.size(40.dp)) {
        Image(painter = painterResource(id = R.drawable.profile), contentDescription = "Profile")

    }
}

@Composable
private fun AddressTag() {
    return Row(
        Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(5.dp)
        ,
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.location), contentDescription = "location")
        Text("My Flat", style = Typography.labelMedium.copy(fontSize = 12.sp, color = Dark))
        Image(
            painter = painterResource(id = R.drawable.down),
            contentDescription = "down",
            Modifier
                .width(10.dp)
                .height(16.dp)
        )
    }

}