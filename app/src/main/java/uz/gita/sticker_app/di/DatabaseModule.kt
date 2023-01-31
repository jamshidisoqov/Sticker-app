package uz.gita.sticker_app.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.sticker_app.data.local.room.StickerDatabase
import uz.gita.sticker_app.data.local.room.dao.StickerDao
import javax.inject.Singleton

// Created by Jamshid Isoqov on 1/30/2023
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun provideStickerDatabase(@ApplicationContext ctx: Context): StickerDatabase =
        Room.databaseBuilder(ctx, StickerDatabase::class.java, "stickers.db")
            .build()

    @[Provides Singleton]
    fun provideSharedPreferences(@ApplicationContext ctx: Context): SharedPreferences =
        ctx.getSharedPreferences("app_data", Context.MODE_PRIVATE)

    @[Provides Singleton]
    fun provideStickerDao(stickerDatabase: StickerDatabase): StickerDao =
        stickerDatabase.stickerDao()

}