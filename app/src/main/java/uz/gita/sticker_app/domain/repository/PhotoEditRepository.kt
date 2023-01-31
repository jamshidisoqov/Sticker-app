package uz.gita.sticker_app.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.sticker_app.data.local.room.entity.StickerEntity

// Created by Jamshid Isoqov on 1/28/2023
interface PhotoEditRepository {

    suspend fun saveSticker(stickerEntity: StickerEntity)

    suspend fun updateSticker(stickerEntity: StickerEntity)

    fun getAllRecentStickers():Flow<List<StickerEntity>>

}