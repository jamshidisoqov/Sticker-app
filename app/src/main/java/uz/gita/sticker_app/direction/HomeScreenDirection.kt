package uz.gita.sticker_app.direction

import android.net.Uri

// Created by Jamshid Isoqov on 1/30/2023
interface HomeScreenDirection {

    suspend fun navigateToEdit(uri: Uri?)

}