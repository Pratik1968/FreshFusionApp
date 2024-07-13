package com.pratikshekhar.myproject.freshfusion.api

import com.pratikshekhar.myproject.freshfusion.data.model.Response.CustomResponse
import com.pratikshekhar.myproject.freshfusion.domain.model.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface  PostUserInfo{
    @POST("/api/user/")
    suspend fun post(
        @Body data:UserData
    ): Response<CustomResponse>
}