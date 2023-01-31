package uz.gita.sticker_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.sticker_app.navigation.NavigationDispatcher
import uz.gita.sticker_app.navigation.NavigationHandler
import uz.gita.sticker_app.navigation.Navigator
import javax.inject.Singleton

// Created by Jamshid Isoqov on 1/29/2023
@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @[Binds Singleton]
    fun bindHandler(dispatcher:NavigationDispatcher):Navigator

    @[Binds Singleton]
    fun navigator(dispatcher: NavigationDispatcher): NavigationHandler


}