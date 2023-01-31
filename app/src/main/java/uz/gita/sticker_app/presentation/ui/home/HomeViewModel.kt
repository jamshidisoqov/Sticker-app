package uz.gita.sticker_app.presentation.ui.home

import android.net.Uri
import kotlinx.coroutines.flow.Flow

// Created by Jamshid Isoqov on 1/29/2023
interface HomeViewModel {

    val recentPhotosList:Flow<List<String>>

    fun getRecentPhotos()

    fun navigateToEdit(uri: Uri)

    fun navigateToEdit()

}