package com.pratikshekhar.myproject.freshfusion.domain.repository

import android.app.Activity
import com.google.firebase.auth.PhoneAuthProvider
import com.pratikshekhar.myproject.freshfusion.domain.model.PhoneAuth

interface PhoneAuthRepository {
    suspend fun authenticateUser(data:PhoneAuth,currentActivity:Activity,callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks)
}