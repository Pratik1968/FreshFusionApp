package com.pratikshekhar.myproject.freshfusion.presentation.screens.home.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.LightGrey2
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun CategoriesItem(
    modifier: Modifier=Modifier,
    @DrawableRes icon: Int = R.drawable.apple_illustration,
    contentDescription: String = "fruit",
    title:String = "Fruit"
) {
    Column(modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){

ImageContainer(icon,contentDescription)
        Spacer(modifier = Modifier.height(8.dp))
    Title(title)
    }
}



@Composable
private fun ImageContainer(    @DrawableRes icon: Int = R.drawable.apple_illustration,
                               contentDescription: String = "fruit"

){
    Box(
        Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(100))
            .background(LightGrey2)
            .padding(20.dp),

    ) {
        Image(painter = painterResource(id = icon), contentDescription = contentDescription)
    }
}
@Composable
private fun  Title(value:String="Fruit"){
Text(value, style = Typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Dark))
}