package uz.gita.sticker_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.sticker_app.domain.repository.PhotoEditRepository
import uz.gita.sticker_app.domain.repository.StartScreenRepository
import uz.gita.sticker_app.domain.repository.impl.PhotoEditRepositoryImpl
import uz.gita.sticker_app.domain.repository.impl.StartScreenRepositoryImpl
import javax.inject.Singleton

// Created by Jamshid Isoqov on 1/30/2023
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindStartScreenRepository(impl: StartScreenRepositoryImpl): StartScreenRepository

    @[Binds Singleton]
    fun bindPhotoEditRepository(impl: PhotoEditRepositoryImpl): PhotoEditRepository


}