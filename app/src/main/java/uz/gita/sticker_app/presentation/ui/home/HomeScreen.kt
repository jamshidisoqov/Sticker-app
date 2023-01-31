package uz.gita.sticker_app.presentation.ui.home

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import uz.gita.sticker_app.R
import uz.gita.sticker_app.databinding.ScreenHomeBinding
import uz.gita.sticker_app.presentation.presenter.HomeViewModelImpl
import uz.gita.sticker_app.utils.CLICK_TIMEOUT
import uz.gita.sticker_app.utils.checkPermission
import uz.gita.sticker_app.utils.include


// Created by Jamshid Isoqov on 1/29/2023
@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {

    private val viewBinding: ScreenHomeBinding by viewBinding()

    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    private val content =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result != null) {
                result.data?.let {
                    viewModel.navigateToEdit(it.data!!)
                }
            }
        }

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {
        imageCamera.clicks()
            .debounce(CLICK_TIMEOUT)
            .onEach {
                openCamera()
            }.launchIn(lifecycleScope)
        imageGallery.clicks()
            .debounce(CLICK_TIMEOUT)
            .onEach {
                openGallery()
            }.launchIn(lifecycleScope)
        imageDraw.clicks()
            .debounce(CLICK_TIMEOUT)
            .onEach {
                viewModel.navigateToEdit()
            }.launchIn(lifecycleScope)
    }

    private fun openGallery() {
        checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, onGranted = {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            content.launch(intent)
        }, onDenied = {
            Snackbar.make(
                viewBinding.imageCamera,
                resources.getString(R.string.permission_denied),
                Snackbar.LENGTH_SHORT
            )
                .setAction(resources.getString(R.string.try_check)) { openGallery() }
                .show()
        })
    }

    private fun openCamera() {
        checkPermission(Manifest.permission.CAMERA, onGranted = {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            content.launch(intent)
        }, onDenied = {
            Snackbar.make(
                viewBinding.imageCamera,
                resources.getString(R.string.permission_denied),
                Snackbar.LENGTH_SHORT
            )
                .setAction(resources.getString(R.string.try_check)) { openGallery() }
                .show()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        content.unregister()
    }

}