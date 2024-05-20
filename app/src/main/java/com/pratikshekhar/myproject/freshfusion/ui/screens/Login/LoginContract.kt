package com.pratikshekhar.myproject.freshfusion.ui.screens.Login

class LoginContract{
  data class states  (var phoneNumber: String,var placeholderVisible:Boolean,var navigationChange:Boolean,var destination:String,var verificationId:String)
}