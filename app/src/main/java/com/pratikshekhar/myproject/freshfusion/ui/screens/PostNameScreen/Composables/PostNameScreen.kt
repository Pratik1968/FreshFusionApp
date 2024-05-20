package com.pratikshekhar.myproject.freshfusion.ui.screens.PostNameScreen.Composables


import android.app.Activity
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.DottedBorderInput
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.LargeButton
import com.pratikshekhar.myproject.freshfusion.ui.screens.Composables.LoginContainerColumnWithLogoTitleAndDescription
import com.pratikshekhar.myproject.freshfusion.ui.screens.PostNameScreen.PostNameViewModel
import com.pratikshekhar.myproject.freshfusion.ui.theme.BottomPadding
import com.pratikshekhar.myproject.freshfusion.ui.theme.ContentPaddingHorizontal
import com.pratikshekhar.myproject.freshfusion.ui.theme.Primary
import com.pratikshekhar.myproject.freshfusion.ui.theme.TopPadding

@Preview(showBackground = true)
@Composable
private fun PreviewPostNameScreen(){
    val viewModel = viewModel { PostNameViewModel() }

    RootLayout(viewModel =viewModel, activity = null)
}
@Composable
fun PostNameScreen() {
    val view = LocalView.current.context as Activity
    val viewModel = viewModel { PostNameViewModel() }
    RootLayout(viewModel = viewModel,activity=view )
}

@Composable
private fun RootLayout(
    viewModel: PostNameViewModel,

    activity: Activity?
) {



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
        LoginContainerColumnWithLogoTitleAndDescription(title = stringResource(R.string.enter_your_name), description = stringResource(
            R.string.this_name_wil_display_on_the_receipt
        ) )
        Spacer(Modifier.height(35.dp))
        DottedBorderInput(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = ContentPaddingHorizontal),
            onValueChange = {
                            viewModel.setName(it)
            },
            fontSize = 18.sp

        )
        Spacer(Modifier.weight(1f))
        ContinueButton(viewModel = viewModel)

    }
}
@Composable
private fun ContinueButton(viewModel: PostNameViewModel) {
    LargeButton(
        modifier = Modifier.padding(), text = stringResource(R.string.Continue),
        onClick = {

                viewModel.onClick()
        },
        colors = ButtonDefaults.buttonColors(Primary),

        )
}