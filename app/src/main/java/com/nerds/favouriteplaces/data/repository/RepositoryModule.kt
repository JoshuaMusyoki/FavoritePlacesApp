package com.nerds.favouriteplaces.data.repository

import android.content.Context
import com.nerds.favouriteplaces.domain.repository.PlacesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class RepositoryModule {
    @Provides
    @Singleton

    fun providePlacesRepository(@ApplicationContext context: Context) : PlacesRepository {
        return PlacesRepositoryImpl(context)
    }
}