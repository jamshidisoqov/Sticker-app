package uz.gita.sticker_app.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import uz.gita.sticker_app.data.local.room.entity.StickerEntity

// Created by Jamshid Isoqov on 1/30/2023
@Dao
interface StickerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSticker(stickerEntity: StickerEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSticker(stickerEntity: StickerEntity)

    @Delete
    suspend fun deleteSticker(stickerEntity: StickerEntity)

    @Query("SELECT*FROM sticker")
    fun getAllStickers():Flow<List<StickerEntity>>

}