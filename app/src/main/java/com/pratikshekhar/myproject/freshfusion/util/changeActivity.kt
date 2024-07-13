package com.pratikshekhar.myproject.freshfusion.util

import androidx.compose.runtime.Composable
import com.pratikshekhar.myproject.freshfusion.ProjectNavigationController
import com.pratikshekhar.myproject.freshfusion.presentation.screens.base.BaseViewModel

@Composable
fun changeActivity(viewModel:BaseViewModel,destination:String) {
    if (viewModel.baseState.goToActivity && viewModel.baseState.destination.isNotBlank()) {
        val nav = ProjectNavigationController.current
        nav.navigate(destination)

    }
}
@Composable
fun changeActivity(viewModel: BaseViewModel,destination:String,args:String){
    if (viewModel.baseState.goToActivity && viewModel.baseState.destination.isNotBlank()) {
        val nav = ProjectNavigationController.current
        nav.navigate(destination+args)
    }



}