package uz.gita.sticker_app.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.sticker_app.direction.SplashScreenDirection
import uz.gita.sticker_app.domain.model.StartScreen
import uz.gita.sticker_app.domain.repository.StartScreenRepository
import uz.gita.sticker_app.presentation.ui.splash.SplashViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val direction:SplashScreenDirection,
    private val startScreenRepository: StartScreenRepository
) : SplashViewModel,ViewModel() {
    override fun navigateToScreen() {
        viewModelScope.launch {
            when (startScreenRepository()) {
                StartScreen.INTRO -> direction.navigateToIntro()
                StartScreen.HOME -> direction.navigateToHome()
            }
        }
    }
}