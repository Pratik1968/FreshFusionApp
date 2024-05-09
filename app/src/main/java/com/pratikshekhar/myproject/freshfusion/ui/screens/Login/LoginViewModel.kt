package com.pratikshekhar.myproject.freshfusion.ui.screens.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    private val placeholder:String ="(000) 000 000"
    var states by mutableStateOf<LoginContract.states>(LoginContract.states(phoneNumber = placeholder,true))
        private  set
    fun setPhoneNumber(text :String){

        if(states.phoneNumber==placeholder){

            states = states.copy(phoneNumber = "")
        }
              states.placeholderVisible = false
    if(states.phoneNumber.length<10)    states = states.copy( phoneNumber =states.phoneNumber+text)

    }
    fun popLastPhoneNumber(){
        val text = states.phoneNumber

        if(text.isNotEmpty() && !states.placeholderVisible)   states  = states.copy(phoneNumber = text.substring(0,text.length-1))
     }


}