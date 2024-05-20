package com.pratikshekhar.myproject.freshfusion.ui.screens.Login.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.ui.screens.Login.LoginViewModel
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingHorizontal
import com.pratikshekhar.myproject.freshfusion.ui.theme.LightGray2
import com.pratikshekhar.myproject.freshfusion.ui.theme.Typography
private  val LocalViewModel = compositionLocalOf <LoginViewModel>{ error("Local View Model not found") }
@Preview(showBackground = true)
@Composable
private  fun Preview(){
    NumberPad(viewModel = LoginViewModel())
}
@Composable
fun NumberPad(modifier: Modifier = Modifier, viewModel: LoginViewModel) {
    CompositionLocalProvider(LocalViewModel provides viewModel){
        Row(
            modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = ContentPaddingHorizontal)
                .background(LightGray2)
                .clip(RoundedCornerShape(24.dp))

        ) {

            CustomColumn(Modifier.weight(1f)) {
                NumberPadButton(text = "1")
                NumberPadButton(text = "4")
                NumberPadButton(text = "7")

                NumberPadButton(text = "1",isVisible = false)
            }
            CustomColumn(Modifier.weight(1f)) {
                NumberPadButton(text = "2")
                NumberPadButton(text = "5")
                NumberPadButton(text = "8")
                NumberPadButton(text = "0")

            }
            CustomColumn(Modifier.weight(1f)) {
                NumberPadButton(text = "3")
                NumberPadButton(text = "6")
                NumberPadButton(text = "9")

                ImagePadButton()
            }
        }
    }
}




@Composable
private fun NumberPadButton(
    modifier: Modifier=Modifier,
    text:String,
    isVisible:Boolean= true
){
    val viewModel = LocalViewModel.current
    Box(
        modifier.clickable(
            onClick = {

            if (isVisible) viewModel.setPhoneNumber(text)
            }
        ).then(
            if(!isVisible){
                Modifier.alpha(0f)
            }else{
                Modifier
            }

        ),
        contentAlignment = Alignment.Center,


    ){
        Text(text,
style = Typography.labelMedium.copy(color= Color.Black),

            )
    }
}
@Composable
private fun CustomColumn(modifier: Modifier=Modifier, content: @Composable() (ColumnScope.() -> Unit)){
  Column(
      modifier.fillMaxHeight(),
verticalArrangement = Arrangement.SpaceEvenly,
      horizontalAlignment = Alignment.CenterHorizontally,
      content = content)
}
@Composable
private fun ImagePadButton(
){
    val viewModel = LocalViewModel.current
    Box(
        Modifier.clickable(
            onClick = {
                viewModel.popLastPhoneNumber()
            }
        ),
        contentAlignment = Alignment.Center,


        ){
        Image(painterResource(id = R.drawable.delete),contentDescription = "delete",modifier = Modifier.size(18.dp))
    }
}