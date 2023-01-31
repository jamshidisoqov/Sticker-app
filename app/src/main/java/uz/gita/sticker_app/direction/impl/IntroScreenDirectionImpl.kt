package uz.gita.sticker_app.direction.impl

import uz.gita.sticker_app.direction.IntroScreenDirection
import uz.gita.sticker_app.navigation.Navigator
import uz.gita.sticker_app.presentation.ui.intro.IntroScreenDirections
import javax.inject.Inject

class IntroScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : IntroScreenDirection {
    override suspend fun navigateToMain() {
        navigator.navigateTo(IntroScreenDirections.actionIntroScreenToHomeScreen())
    }
}