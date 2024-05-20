package com.pratikshekhar.myproject.freshfusion.data.repository

import android.app.Activity
import android.content.Context
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.pratikshekhar.myproject.freshfusion.domain.model.PhoneAuth
import com.pratikshekhar.myproject.freshfusion.domain.repository.PhoneAuthRepository
import java.util.concurrent.TimeUnit

class PhoneAuthRepositoryImpl : PhoneAuthRepository {
    override suspend fun authenticateUser(data: PhoneAuth,currentActivity:Activity,callbacks:PhoneAuthProvider.OnVerificationStateChangedCallbacks) {
val options = PhoneAuthOptions.newBuilder()

    .setPhoneNumber(data.countryCode+data.phoneNumber)
    .setActivity(currentActivity)
    .setTimeout(60L, TimeUnit.SECONDS)
    .setCallbacks(callbacks)
    .build()
        PhoneAuthProvider.verifyPhoneNumber(options)


    }

}