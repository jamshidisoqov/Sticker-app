package uz.gita.sticker_app.data.local

import android.content.Context
import android.content.SharedPreferences
import uz.gita.sticker_app.utils.SharedPreference
import javax.inject.Inject

// Created by Jamshid Isoqov on 1/28/2023
class MySharedPref @Inject constructor(
    context: Context,
    pref: SharedPreferences
) : SharedPreference(context = context, preferences = pref) {

    val isFirstApp: Boolean by Booleans(true)

}