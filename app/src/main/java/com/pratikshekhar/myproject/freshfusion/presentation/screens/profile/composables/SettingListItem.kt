package com.pratikshekhar.myproject.freshfusion.presentation.screens.profile.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun SettingListItem(@DrawableRes image:Int= R.drawable.ic_logout, contentDescription:String="logout", title:String="Logout",onClick:()->Unit={}){
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(interactionSource =interactionSource , indication = null) {
onClick()
            }
        , verticalAlignment = Alignment.CenterVertically) {
Image(painter = painterResource(id = image), contentDescription = contentDescription)
Spacer(modifier = Modifier.width(31.dp))
        Text(text = title, style = Typography.bodyMedium.copy(color = Dark))
    }
}