package com.pratikshekhar.myproject.freshfusion.presentation.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pratikshekhar.myproject.freshfusion.presentation.screens.profile.composables.Header
import com.pratikshekhar.myproject.freshfusion.presentation.screens.profile.composables.ProfilePic
import com.pratikshekhar.myproject.freshfusion.presentation.screens.profile.composables.SettingList
import com.pratikshekhar.myproject.freshfusion.presentation.viewmodel.ProfileViewModel

@Preview(showBackground = true)
@Composable
fun ProfileScreen(modifier: Modifier=Modifier){
    val viewModel = viewModel{ ProfileViewModel() }

    Column(
      modifier
          .fillMaxSize()
          .padding(start = 18.dp, end = 18.dp, top = 24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
Header()
      Spacer(modifier = Modifier.height(44.dp))
      ProfilePic()
      Spacer(modifier = Modifier.height(56.dp))

      SettingList(viewModel)

  }
}