package uz.gita.sticker_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import uz.gita.sticker_app.direction.HomeScreenDirection
import uz.gita.sticker_app.direction.IntroScreenDirection
import uz.gita.sticker_app.direction.SplashScreenDirection
import uz.gita.sticker_app.direction.impl.HomeScreenDirectionImpl
import uz.gita.sticker_app.direction.impl.IntroScreenDirectionImpl
import uz.gita.sticker_app.direction.impl.SplashScreenDirectionImpl

// Created by Jamshid Isoqov on 1/29/2023
@Module
@InstallIn(ViewModelComponent::class)
interface DirectionsModule {


    @Binds
    fun bindSplashScreen(impl:SplashScreenDirectionImpl):SplashScreenDirection

    @Binds
    fun bindIntroScreen(impl:IntroScreenDirectionImpl):IntroScreenDirection

    @Binds
    fun bindHomeScreen(impl:HomeScreenDirectionImpl):HomeScreenDirection

}