package uz.gita.sticker_app.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Jamshid Isoqov on 1/30/2023
@Entity(tableName = "sticker")
data class StickerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val uri: String,
    val updatedDate: Long = System.currentTimeMillis(),
    val createdDate: Long = System.currentTimeMillis()
)