package com.pratikshekhar.myproject.freshfusion.ui.screens.Login

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.pratikshekhar.myproject.freshfusion.data.repository.PhoneAuthRepositoryImpl
import com.pratikshekhar.myproject.freshfusion.domain.model.PhoneAuth
import com.pratikshekhar.myproject.freshfusion.domain.repository.PhoneAuthRepository
import com.pratikshekhar.myproject.freshfusion.util.NavDestination
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel(){
    private val placeholder:String ="(000) 000 000"
    var states by mutableStateOf<LoginContract.states>(LoginContract.states(phoneNumber = placeholder, placeholderVisible = true,navigationChange = false, destination = NavDestination.HOME_SCREEN, verificationId = ""))
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
    fun onClick(activity: Activity){

        val phoneAuthRepository: PhoneAuthRepository = PhoneAuthRepositoryImpl ()
        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
states = states.copy( destination = NavDestination.HOME_SCREEN, navigationChange = true)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                p0.message?.let { Log.d("FirebaseError", it) }
                Toast.makeText(activity.baseContext,p0.message,Toast.LENGTH_SHORT).show();

            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {

                states = states.copy(verificationId = p0, destination = NavDestination.OTP_VERIFICATION_SCREEN, navigationChange = true)
                super.onCodeSent(p0, p1)
            }
        }

        viewModelScope.launch {
            phoneAuthRepository.authenticateUser(
                data=PhoneAuth(
                    states.phoneNumber,
                    countryCode = "+91",
                ),
                currentActivity = activity,
                callbacks = callbacks
            )
        }

}

}
