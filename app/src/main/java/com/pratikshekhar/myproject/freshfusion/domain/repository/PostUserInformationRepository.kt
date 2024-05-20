package com.pratikshekhar.myproject.freshfusion.domain.repository

import com.pratikshekhar.myproject.freshfusion.domain.model.UserData

interface PostUserInformationRepository {
    fun Post(data:UserData)
}