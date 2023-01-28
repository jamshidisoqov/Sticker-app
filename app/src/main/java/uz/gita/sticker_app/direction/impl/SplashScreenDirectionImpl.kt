package uz.gita.sticker_app.direction.impl

import uz.gita.sticker_app.direction.SplashScreenDirection
import uz.gita.sticker_app.navigation.Navigator
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : SplashScreenDirection {
    override suspend fun navigateToHome() {
        TODO("Not yet implemented")
    }

    override suspend fun navigateToIntro() {
        TODO("Not yet implemented")
    }
}