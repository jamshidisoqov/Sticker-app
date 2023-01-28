package uz.gita.sticker_app.utils
// Created by Jamshid Isoqov an 10/12/2022


fun Throwable.getMessage() = this.message ?: "Unknown error"

fun noInternetConnection():Throwable =Throwable("No internet connection")