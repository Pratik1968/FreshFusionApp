package com.pratikshekhar.myproject.freshfusion.util

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.pratikshekhar.myproject.freshfusion.presentation.screens.base.BaseViewModel

fun showMessage(v: String,activity:Activity){
    Toast.makeText(activity,v,Toast.LENGTH_SHORT).show()
}
@Composable
fun setUpToast(viewModel:BaseViewModel,activity: Activity){
    if(viewModel.baseState.showMessageInToastVisible){
        showMessage(viewModel.baseState.toastMessageText,activity)
   viewModel.setShowMessageInToast(false)
    }
}