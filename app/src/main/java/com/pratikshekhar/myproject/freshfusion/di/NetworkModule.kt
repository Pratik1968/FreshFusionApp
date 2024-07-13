package com.pratikshekhar.myproject.freshfusion.di

import com.pratikshekhar.myproject.freshfusion.BuildConfig
import com.pratikshekhar.myproject.freshfusion.api.PostUserInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{

        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
@Singleton
@Provides
    fun postUser(retrofit: Retrofit):PostUserInfo{
        return retrofit.create(PostUserInfo::class.java)
    }



}