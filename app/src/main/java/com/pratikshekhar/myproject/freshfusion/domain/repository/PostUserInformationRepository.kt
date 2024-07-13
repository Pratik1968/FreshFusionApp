package com.pratikshekhar.myproject.freshfusion.domain.repository

import com.pratikshekhar.myproject.freshfusion.domain.model.UserData

interface PostUserInformationRepository {
   suspend fun Post(data:UserData,onFailure:()->Unit,onComplete:()->Unit)
}