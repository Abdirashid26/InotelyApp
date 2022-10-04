package com.example.inotelyapp.data.di

import com.example.inotelyapp.data.FirebaseDatabaseRepo
import com.example.inotelyapp.data.FirebaseRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FireBaseModule {


    @Provides
    @Singleton
    fun providesFirebaseRepo() : FirebaseRepo{
        return FirebaseRepo()
    }

    @Provides
    @Singleton
    fun providesFirebaseDatabaseRepo() : FirebaseDatabaseRepo{
        return FirebaseDatabaseRepo()
    }


}