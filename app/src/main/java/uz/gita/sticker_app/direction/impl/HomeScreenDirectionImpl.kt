package uz.gita.sticker_app.direction.impl

import android.net.Uri
import uz.gita.sticker_app.direction.HomeScreenDirection
import uz.gita.sticker_app.navigation.Navigator
import uz.gita.sticker_app.presentation.ui.home.HomeScreenDirections
import javax.inject.Inject

class HomeScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
): HomeScreenDirection {
    override suspend fun navigateToEdit(uri: Uri?) {
        navigator.navigateTo(HomeScreenDirections.actionHomeScreenToEditorScreen(uri?.toString()))
    }
}