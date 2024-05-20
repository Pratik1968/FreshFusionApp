package com.pratikshekhar.myproject.freshfusion.ui.screens.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingHorizontal
import com.pratikshekhar.myproject.freshfusion.ui.theme.Dark
import com.pratikshekhar.myproject.freshfusion.ui.theme.LightGrey
import com.pratikshekhar.myproject.freshfusion.ui.theme.Typography
@Preview(showBackground = true)
@Composable
private  fun Preview(){
    LoginContainerColumnWithLogoTitleAndDescription(title = "Enter your mobile number", description ="We will send you a verification code" )
}
@Composable
fun LoginContainerColumnWithLogoTitleAndDescription(modifier: Modifier=Modifier,title:String,description:String){
    Column(
        modifier.fillMaxWidth().padding(horizontal = ContentPaddingHorizontal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
Logo()
        Title(text = title)
        Description(text = description)
    }
}
@Composable
private  fun Logo(modifier: Modifier = Modifier){
    Image(painter = painterResource(id = R.drawable.logo_with_green_background),modifier=modifier.size(80.dp), contentDescription = "leaf3" )

}
@Composable
private  fun Title(text:String){
    Text(text,
        color = Dark,
        style = Typography.titleLarge,
        textAlign = TextAlign.Center

    )
}
@Composable
private  fun Description(text:String){
    Text(
        text,
        color= LightGrey,
        style = Typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}