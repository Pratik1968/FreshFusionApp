package com.pratikshekhar.myproject.freshfusion.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileViewModel:ViewModel() {
    val auth = Firebase.auth
    fun logout(callback:()->Unit){
        auth.signOut()
        callback()

    }
}