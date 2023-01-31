package uz.gita.sticker_app.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.sticker_app.data.local.room.dao.StickerDao
import uz.gita.sticker_app.data.local.room.entity.StickerEntity

// Created by Jamshid Isoqov on 1/30/2023
@Database(entities = [StickerEntity::class], version = 1, exportSchema = false)
abstract class StickerDatabase : RoomDatabase() {

    abstract fun stickerDao(): StickerDao

}