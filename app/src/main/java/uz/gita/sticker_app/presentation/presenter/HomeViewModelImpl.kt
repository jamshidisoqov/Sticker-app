package uz.gita.sticker_app.presentation.presenter

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.sticker_app.direction.HomeScreenDirection
import uz.gita.sticker_app.domain.repository.PhotoEditRepository
import uz.gita.sticker_app.presentation.ui.home.HomeViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val repository: PhotoEditRepository,
    private val direction: HomeScreenDirection
) : HomeViewModel, ViewModel() {

    override val recentPhotosList: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

    override fun getRecentPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllRecentPhotos().collectLatest {
                recentPhotosList.emit(it)
            }
        }
    }

    override fun navigateToEdit(uri: Uri) {
        viewModelScope.launch {
            direction.navigateToEdit(uri)
        }
    }

    override fun navigateToEdit() {
        viewModelScope.launch {
            direction.navigateToEdit(null)
        }
    }
}