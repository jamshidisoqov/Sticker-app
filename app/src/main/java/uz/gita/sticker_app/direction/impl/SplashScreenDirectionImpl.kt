package uz.gita.sticker_app.direction.impl

import uz.gita.sticker_app.direction.SplashScreenDirection
import uz.gita.sticker_app.navigation.Navigator
import uz.gita.sticker_app.presentation.ui.splash.SplashScreenDirections
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : SplashScreenDirection {
    override suspend fun navigateToHome() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToHomeScreen())
    }

    override suspend fun navigateToIntro() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToIntroScreen())
    }
}