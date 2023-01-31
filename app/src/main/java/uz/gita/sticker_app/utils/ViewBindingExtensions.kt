package uz.gita.sticker_app.utils

import androidx.viewbinding.ViewBinding

// Created by Jamshid Isoqov on 1/28/2023
fun <T : ViewBinding> T.include(block: T.() -> Unit) {
    block(this)
}

