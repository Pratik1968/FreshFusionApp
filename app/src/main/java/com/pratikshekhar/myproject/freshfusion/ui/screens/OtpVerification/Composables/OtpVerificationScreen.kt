package com.pratikshekhar.myproject.freshfusion.ui.screens.OtpVerification.Composables

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.DottedBorderInput
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.LargeButton
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.LoginContainerColumnWithLogoTitleAndDescription
import com.pratikshekhar.myproject.freshfusion.ui.screens.OtpVerification.OtpVerificationViewModel
import com.pratikshekhar.myproject.freshfusion.ui.theme.BottomPadding
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingHorizontal
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingVertical
import com.pratikshekhar.myproject.freshfusion.ui.theme.Primary
import com.pratikshekhar.myproject.freshfusion.ui.theme.TopPadding

@Preview(showBackground = true)
@Composable
private fun PreviewOtp(){
    val viewModel = viewModel {OtpVerificationViewModel()}

    RootLayout(viewModel =viewModel,verificationId = "", activity = null)
}
@Composable
fun OtpVerificationScreen(verificationId: String?) {
    val view = LocalView.current.context as Activity
   val viewModel = viewModel {OtpVerificationViewModel()}
RootLayout(viewModel = viewModel,verificationId = verificationId,activity=view )
}

@Composable
private  fun RootLayout(
    viewModel: OtpVerificationViewModel,
    verificationId: String?,
    activity: Activity?
) {
    if (verificationId != null) {
        viewModel.setVerificationID(verificationId)
    }


Column(
    Modifier
        .fillMaxSize()
        .padding(
            top = TopPadding,
            bottom = BottomPadding

        )
,
    horizontalAlignment = Alignment.CenterHorizontally,

) {
LoginContainerColumnWithLogoTitleAndDescription(title = "Enter your otp", description ="Please enter the otp that is sent in your phone" )
Spacer(Modifier.height(35.dp))
    DottedBorderInput(
      modifier =   Modifier
            .fillMaxWidth(0.5f)
            .padding(horizontal = ContentPaddingHorizontal),
onValueChange = {
    viewModel.setOtp(it)
},
        fontSize = 24.sp

    )
Spacer(Modifier.weight(1f))
    VerifyButton(viewModel = viewModel,activity = activity)

}
}
@Composable
private fun VerifyButton(viewModel: OtpVerificationViewModel, activity: Activity?) {
    LargeButton(modifier = Modifier.padding(),text = "Verify", onClick = {

        if (activity != null) {
            viewModel.onClick(activity)
        };
    },
        colors = ButtonDefaults.buttonColors(Primary),

    )
}