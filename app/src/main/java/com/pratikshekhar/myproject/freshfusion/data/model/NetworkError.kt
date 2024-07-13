package com.pratikshekhar.myproject.freshfusion.data.model

 class NetworkError(
     val code:Int, override val message:String,

     ) :Throwable(message)
