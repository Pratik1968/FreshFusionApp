package com.pratikshekhar.myproject.freshfusion.presentation.screens.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class BaseState( val goToActivity:Boolean,

val showMessageInToastVisible:Boolean,
val  toastMessageText:String,
    val destination:String

    )
open class BaseViewModel:ViewModel(){
    var  baseState by mutableStateOf<BaseState>(BaseState(goToActivity = false,showMessageInToastVisible = false, toastMessageText = "", destination = ""))
       private set

    fun setGoToActivity(v:Boolean, destination: String=""){
        baseState = baseState.copy(goToActivity = v, destination = destination)
    }
    fun setShowMessageInToast(v:Boolean,text:String = ""){
        baseState = baseState.copy(showMessageInToastVisible = v, toastMessageText = text)

    }


}