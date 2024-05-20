package com.pratikshekhar.myproject.freshfusion.ui.screens.Login.Composables

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pratikshekhar.myproject.freshfusion.ProjectNavigationController
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.LargeButton
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.LoginContainerColumnWithLogoTitleAndDescription
import com.pratikshekhar.myproject.freshfusion.ui.screens.Login.LoginViewModel
import com.pratikshekhar.myproject.freshfusion.ui.screens.OtpVerification.OtpVerificationContract
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingHorizontal
import com.pratikshekhar.myproject.freshfusion.ui.theme.LightGrey
import com.pratikshekhar.myproject.freshfusion.ui.theme.Primary
import com.pratikshekhar.myproject.freshfusion.ui.theme.Typography
import com.pratikshekhar.myproject.freshfusion.util.NavDestination
import com.pratikshekhar.myproject.freshfusion.util.SetStatusBarColor
import com.pratikshekhar.myproject.freshfusion.util.SetThemeBar
@Preview(showBackground = true)
@Composable
private fun Preview(){
    val viewModel = viewModel{ LoginViewModel() }
    RootLayout(viewModel,null)
}
@Composable
fun LoginScreen(){
val viewModel = viewModel{ LoginViewModel() }
    SetStatusBarColor(color = Color.White)
    SetThemeBar(value = true)
    val nav= ProjectNavigationController.current
    RootLayout(viewModel,nav)
}
@Composable
private  fun RootLayout(viewModel: LoginViewModel, nav: NavHostController?) {

    Column(
        Modifier
            .fillMaxSize()

            .padding(bottom = 16.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    )   {
Spacer(modifier = Modifier.weight(0.1f))
        LoginContainerColumnWithLogoTitleAndDescription(

            title = "Enter your mobile number",
            description = "We will send you a verification code",

        )
      //  Spacer(Modifier.height(48.dp))
        PhoneNumberInput(Modifier.weight(0.3f),viewModel=viewModel)
        Spacer(modifier = Modifier.height(56.dp))
        ContinueButton(Modifier.weight(0.2f), viewModel=viewModel,nav)
        Spacer(modifier = Modifier.height(24.dp))
        TermsText(Modifier.weight(0.2f))
        Spacer(modifier =Modifier.height( 24.dp))
        NumberPad(modifier=Modifier.weight(1.0f),viewModel)
    }
}

@Composable
private fun ContinueButton(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    nav: NavHostController?
) {
    val view = LocalView.current
    LaunchedEffect(viewModel.states.navigationChange){
        val destination = viewModel.states.destination
        if(viewModel.states.navigationChange && destination == NavDestination.OTP_VERIFICATION_SCREEN){
        val args = viewModel.states.verificationId
            nav?.navigate(NavDestination.OTP_VERIFICATION_SCREEN+"/$args")
        }else if(viewModel.states.navigationChange && destination == NavDestination.HOME_SCREEN){
            nav?.navigate(NavDestination.HOME_SCREEN)
        }
    }
LargeButton(modifier = modifier.padding(),text = "Continue", onClick = {
    viewModel.onClick(view.context as Activity,);
},
colors = ButtonDefaults.buttonColors(Primary)
    )
}
@Composable
private fun TermsText(modifier: Modifier=Modifier){
    Text(
        "By clicking on “Continue” you are agreeing to our terms of use ",
modifier = modifier.padding(horizontal =  ContentPaddingHorizontal),
        style = Typography.bodyMedium.copy(color = LightGrey, textAlign = TextAlign.Center)

        )
}