package com.pratikshekhar.myproject.freshfusion.presentation.screens.postAddressScreen

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pratikshekhar.myproject.freshfusion.ProjectNavigationController
import com.pratikshekhar.myproject.freshfusion.R
import com.pratikshekhar.myproject.freshfusion.presentation.screens.composables.DottedBorderInput
import com.pratikshekhar.myproject.freshfusion.presentation.screens.composables.LargeButton
import com.pratikshekhar.myproject.freshfusion.presentation.screens.composables.LoginContainerColumnWithLogoTitleAndDescription
import com.pratikshekhar.myproject.freshfusion.presentation.theme.BottomPadding
import com.pratikshekhar.myproject.freshfusion.presentation.theme.ContentPaddingHorizontal
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Primary
import com.pratikshekhar.myproject.freshfusion.presentation.theme.TopPadding
import com.pratikshekhar.myproject.freshfusion.presentation.viewmodel.PostAddressViewModel
import com.pratikshekhar.myproject.freshfusion.util.NavDestination

@Preview(showBackground = true)
@Composable
private fun PreviewPostAddress(){
  //  val viewModel = viewModel {PostAddressViewModel() }

    RootLayout(viewModel =null, )
}
@Composable
fun PostAddressScreen(name:String?) {
    val view = LocalView.current.context as Activity
   val postAddressViewModel =hiltViewModel<PostAddressViewModel>()
    //setUpToast(viewModel = viewModel, activity =view )
    postAddressViewModel.setName(name!!)
    RootLayout(viewModel = postAddressViewModel )
}

@Composable
private fun RootLayout(
    viewModel: PostAddressViewModel?,

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
LoginContainerColumnWithLogoTitleAndDescription(title = stringResource(R.string.enter_your_address), description = stringResource(
    R.string.this_is_the_address_where_your_delivery_will_be_sent
) )
Spacer(Modifier.height(35.dp))
    DottedBorderInput(
      modifier = Modifier
          .fillMaxWidth(0.8f)
          .padding(horizontal = ContentPaddingHorizontal),
onValueChange = {
    viewModel?.setAddress(it)
},
        fontSize = 20.sp,
        maxLines = 5
    )
Spacer(Modifier.weight(1f))
    ContinueButton(viewModel = viewModel!!,)

}
}
@Composable
private fun ContinueButton(viewModel: PostAddressViewModel, ) {
    var changeNav by remember {

        mutableStateOf<Boolean>(false)
    }
    if(changeNav){
        ProjectNavigationController.current.navigate(NavDestination.MAIN_SCREEN)
    }
    LargeButton(
        modifier = Modifier.padding(), text = stringResource(id = R.string.Continue),
        onClick = {
            if(viewModel.state.address.isBlank()){
            }else{
            viewModel.onClick(){
              changeNav= true
            }

                Log.d("name",viewModel.state.name)
                Log.d("address",viewModel.state.address)
            }


        },
        colors = ButtonDefaults.buttonColors(Primary),

        )
}