package com.pratikshekhar.myproject.freshfusion.data.repository

import android.util.Log
import com.pratikshekhar.myproject.freshfusion.api.PostUserInfo
import com.pratikshekhar.myproject.freshfusion.domain.model.UserData
import com.pratikshekhar.myproject.freshfusion.domain.repository.PostUserInformationRepository
import javax.inject.Inject

class PostUserInformationRepositoryImpl @Inject constructor(private  val postUserInfoApi:PostUserInfo ) : PostUserInformationRepository {

    override suspend fun Post(data: UserData,onFailure: ()->Unit,onComplete:()->Unit) {
val response  =  postUserInfoApi.post(data)
   if(response.isSuccessful && response.body() !=null){
Log.d("UserPost", response.body()!!.toString())
    Log.d("UserPost","Success")
       onComplete()
   }else{
       Log.d("UserPost","Failed")
onFailure()
   }
    }


}