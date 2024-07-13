package com.pratikshekhar.myproject.freshfusion.presentation.screens.profile.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.ProjectNavigationController
import com.pratikshekhar.myproject.freshfusion.presentation.viewmodel.ProfileViewModel
import com.pratikshekhar.myproject.freshfusion.util.NavDestination

@Preview(showBackground = true)
@Composable
fun SettingList(viewModel: ProfileViewModel?=null) {
var authState by remember {
    mutableStateOf<Boolean>(true)
    }
        if(!authState){
            ProjectNavigationController.current.navigate(NavDestination.INTRO_SCREEN)
        }


    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
    SettingListItem(){
        viewModel?.logout {
authState = false
        }

    }
        Divider(thickness = (0.5).dp)

    }
}