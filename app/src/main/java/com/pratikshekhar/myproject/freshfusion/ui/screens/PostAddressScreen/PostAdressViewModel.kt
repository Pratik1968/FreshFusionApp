package com.pratikshekhar.myproject.freshfusion.ui.screens.PostAddressScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class PostAddressViewModel:ViewModel(){


  var  state by
mutableStateOf<PostAddressContract.states>(PostAddressContract.states(""))
      private set
    fun onClick() {

Log.d("address",state.address)
    }
    fun setAddress(v:String){

        state = state.copy(address = v)

    }





}