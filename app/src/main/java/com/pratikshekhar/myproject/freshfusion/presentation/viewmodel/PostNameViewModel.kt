package com.pratikshekhar.myproject.freshfusion.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.pratikshekhar.myproject.freshfusion.presentation.screens.base.BaseViewModel
import com.pratikshekhar.myproject.freshfusion.presentation.contracts.PostNameContract
import com.pratikshekhar.myproject.freshfusion.util.NavDestination

class PostNameViewModel():BaseViewModel() {


     var  state by
    mutableStateOf<PostNameContract.states>(PostNameContract.states(""))
        private set

    fun onClick(){

        if(state.name.isNotBlank())    setGoToActivity(v=true, destination = NavDestination.POST_ADDRESS)
        else setShowMessageInToast(v = true, text = "Please fill information carefully")


    }
    fun setName(v:String){
 state = state.copy(name = v)

    }




}