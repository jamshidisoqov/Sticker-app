package uz.gita.sticker_app.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.sticker_app.data.local.prefs.MySharedPref
import uz.gita.sticker_app.direction.IntroScreenDirection
import uz.gita.sticker_app.presentation.ui.intro.IntroViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModelImpl @Inject constructor(
    private val direction: IntroScreenDirection,
    private val mySharedPref: MySharedPref
) : IntroViewModel,ViewModel() {
    override fun navigateToMain() {
        viewModelScope.launch {
            mySharedPref.isFirstApp = false
            direction.navigateToMain()
        }
    }
}