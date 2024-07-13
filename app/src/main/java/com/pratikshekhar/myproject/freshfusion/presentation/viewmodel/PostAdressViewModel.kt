package com.pratikshekhar.myproject.freshfusion.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.pratikshekhar.myproject.freshfusion.data.repository.PostUserInformationRepositoryImpl
import com.pratikshekhar.myproject.freshfusion.domain.model.UserData
import com.pratikshekhar.myproject.freshfusion.presentation.contracts.PostAddressContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostAddressViewModel @Inject constructor( application:Application,val postUserInformationRepositoryImpl: PostUserInformationRepositoryImpl) : ViewModel(){

    val sharedPreferences:SharedPreferences =application.getSharedPreferences("UserInfo",Context.MODE_PRIVATE)
  var  state by
mutableStateOf<PostAddressContract.states>(PostAddressContract.states("", name = ""))
      private set
    fun onClick(callback:()->Unit) {
viewModelScope.launch {
    val uuid = FirebaseAuth.getInstance().currentUser?.uid
    val name = state.name
    val address = state.address
    val phoneNumber = FirebaseAuth.getInstance().currentUser?.phoneNumber
val userInfo = UserData(uid=uuid!!,name=name, phoneNumber = phoneNumber!!, address = address)

    postUserInformationRepositoryImpl.Post(userInfo,{}){

        saveInfoInSharePref(userInfo)
        callback()
    }
}
    }
    fun setAddress(v:String){

        state = state.copy(address = v)

    }
    fun setName(v:String){
        state = state.copy(name=v)
    }

   private  fun saveInfoInSharePref(userInfo: UserData) {
with(sharedPreferences.edit()){
   putString("uid",userInfo.uid)
    putString("name",userInfo.name)
    putString("address",userInfo.address)
    putString("phoneNumber",userInfo.phoneNumber)
    commit()
}

    }



}