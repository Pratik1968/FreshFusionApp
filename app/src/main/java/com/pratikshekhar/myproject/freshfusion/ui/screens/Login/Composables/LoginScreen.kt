package com.pratikshekhar.myproject.freshfusion.ui.screens.Login.Composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.LargeButton
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.LoginContainerColumnWithLogoTitleAndDescription
import com.pratikshekhar.myproject.freshfusion.ui.screens.Login.LoginViewModel
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingHorizontal
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingVertical
import com.pratikshekhar.myproject.freshfusion.ui.theme.LightGrey
import com.pratikshekhar.myproject.freshfusion.ui.theme.Primary
import com.pratikshekhar.myproject.freshfusion.ui.theme.Typography
import com.pratikshekhar.myproject.freshfusion.util.SetStatusBarColor
import com.pratikshekhar.myproject.freshfusion.util.SetThemeBar
@Preview(showBackground = true)
@Composable
private fun Preview(){
    val ViewModel = viewModel{ LoginViewModel() }

    RootLayout(ViewModel)
}
@Composable
fun LoginScreen(){
val viewModel = viewModel{ LoginViewModel() }
    SetStatusBarColor(color = Color.White)
    SetThemeBar(value = true)
    RootLayout(viewModel)
}
@Composable
private  fun RootLayout(ViewModel: LoginViewModel) {

    Column(
        Modifier
            .fillMaxSize()

            .padding(top = ContentPaddingVertical, bottom = 16.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    )   {

        LoginContainerColumnWithLogoTitleAndDescription(
            title = "Enter your mobile number",
            description = "We will send you a verification code"
        )
        Spacer(Modifier.height(48.dp))
        PhoneNumberInput(ViewModel)
        Spacer(modifier = Modifier.height(56.dp))
        ContinueButton()
        Spacer(modifier = Modifier.height(24.dp))
        TermsText()
        Spacer(modifier =Modifier.height( 24.dp))
        NumberPad(modifier=Modifier.weight(1.0f),ViewModel)
    }
}

@Composable
private fun ContinueButton(){
LargeButton(modifier = Modifier.padding(),text = "Continue", onClick = {},
colors = ButtonDefaults.buttonColors(Primary)
    )
}
@Composable
private fun TermsText(){
    Text(
        "By clicking on “Continue” you are agreeing to our terms of use ",
modifier = Modifier.padding(horizontal =  ContentPaddingHorizontal),
        style = Typography.bodyMedium.copy(color = LightGrey, textAlign = TextAlign.Center)

        )
}