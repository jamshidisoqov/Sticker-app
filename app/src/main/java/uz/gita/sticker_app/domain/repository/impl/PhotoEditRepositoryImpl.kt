package uz.gita.sticker_app.domain.repository.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.sticker_app.data.local.room.dao.StickerDao
import uz.gita.sticker_app.data.local.room.entity.StickerEntity
import uz.gita.sticker_app.domain.repository.PhotoEditRepository
import javax.inject.Inject

class PhotoEditRepositoryImpl @Inject constructor(
    private val stickerDao: StickerDao
) : PhotoEditRepository {
    override suspend fun saveSticker(stickerEntity: StickerEntity) =
        stickerDao.insertSticker(stickerEntity)

    override suspend fun updateSticker(stickerEntity: StickerEntity)  =
        stickerDao.updateSticker(stickerEntity)

    override fun getAllRecentStickers(): Flow<List<StickerEntity>>  =
        stickerDao.getAllStickers()

}