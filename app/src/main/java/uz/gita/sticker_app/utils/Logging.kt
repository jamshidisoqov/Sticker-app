package uz.gita.sticker_app.utils

import timber.log.Timber

// Created by Jamshid Isoqov on 1/9/2023


fun log(message: String, tag: String = "TTT") {
    Timber.tag(tag).d(message)
}