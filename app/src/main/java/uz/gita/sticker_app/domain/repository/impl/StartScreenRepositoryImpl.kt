package uz.gita.sticker_app.domain.repository.impl

import uz.gita.sticker_app.data.local.prefs.MySharedPref
import uz.gita.sticker_app.domain.model.StartScreen
import uz.gita.sticker_app.domain.repository.StartScreenRepository
import javax.inject.Inject

class StartScreenRepositoryImpl @Inject constructor(
    private val mySharedPref: MySharedPref
) : StartScreenRepository {
    override suspend operator fun invoke(): StartScreen =
        if (mySharedPref.isFirstApp) StartScreen.INTRO
        else StartScreen.HOME
}