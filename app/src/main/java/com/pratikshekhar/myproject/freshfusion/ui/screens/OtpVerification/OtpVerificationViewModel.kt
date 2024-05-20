package com.pratikshekhar.myproject.freshfusion.ui.screens.OtpVerification

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider


class OtpVerificationViewModel:ViewModel(){


  var  state by
mutableStateOf<OtpVerificationContract.states>(OtpVerificationContract.states("",""))
      private set
    fun onClick(activity: Activity,){
if(state.verificationID.isNotEmpty() && state.otp.isNotEmpty()){
    val credential = PhoneAuthProvider.getCredential(state.verificationID, state.otp)
    signInWithPhoneAuthCredential(credential, activity = activity)
}
    }
    fun setOtp(v:String){

        state = state.copy(otp = v)

    }

fun setVerificationID(v:String){
    state = state.copy(verificationID = v)
}
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential,activity:Activity) {
    val auth = FirebaseAuth.getInstance()

    auth.signInWithCredential(credential)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = task.result?.user
                    Toast.makeText(activity,"Success",Toast.LENGTH_SHORT).show()
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w("FirebaseError", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                      Toast.makeText(activity,task.exception?.message,Toast.LENGTH_SHORT).show() // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }



}