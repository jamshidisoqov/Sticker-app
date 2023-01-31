package uz.gita.sticker_app.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.gita.sticker_app.utils.SharedPreference
import javax.inject.Inject

// Created by Jamshid Isoqov on 1/28/2023
class MySharedPref @Inject constructor(
    @ApplicationContext context: Context,
    pref: SharedPreferences
) : SharedPreference(context = context, preferences = pref) {

    var isFirstApp: Boolean by Booleans(true)

}