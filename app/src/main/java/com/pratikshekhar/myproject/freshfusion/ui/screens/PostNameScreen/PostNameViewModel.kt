package com.pratikshekhar.myproject.freshfusion.ui.screens.PostNameScreen

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class PostNameViewModel:ViewModel(){


    var  state by
    mutableStateOf<PostNameContract.states>(PostNameContract.states(""))
        private set
    fun onClick(){
Log.d("name:",state.name)
    }
    fun setName(v:String){

        state = state.copy(name = v)

    }





}