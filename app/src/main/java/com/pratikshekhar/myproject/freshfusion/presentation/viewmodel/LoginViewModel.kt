package com.pratikshekhar.myproject.freshfusion.presentation.viewmodel

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.pratikshekhar.myproject.freshfusion.data.repository.PhoneAuthRepositoryImpl
import com.pratikshekhar.myproject.freshfusion.domain.model.PhoneAuth
import com.pratikshekhar.myproject.freshfusion.domain.repository.PhoneAuthRepository
import com.pratikshekhar.myproject.freshfusion.presentation.screens.base.BaseViewModel
import com.pratikshekhar.myproject.freshfusion.presentation.contracts.LoginContract
import com.pratikshekhar.myproject.freshfusion.util.NavDestination
import kotlinx.coroutines.launch

class LoginViewModel:BaseViewModel(){
    private val placeholder:String ="(000) 000 000"
    var states by mutableStateOf<LoginContract.states>(
        LoginContract.states(
            phoneNumber = placeholder,
            placeholderVisible = true,
            verificationId = ""
        )
    )
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
                setGoToActivity(true)

setGoToActivity( destination = NavDestination.MAIN_SCREEN, v = true)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                p0.message?.let { Log.d("FirebaseError", it) }
                setShowMessageInToast(v = true, text = p0.message.toString())
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {

                states = states.copy(verificationId = p0)
                setGoToActivity( destination = NavDestination.OTP_VERIFICATION_SCREEN, v= true)
                super.onCodeSent(p0, p1)
            }
        }

        if(states.phoneNumber.isNotBlank())
        {
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
        else setShowMessageInToast(v = true, text = "Please fill the information correctly")

}


}
