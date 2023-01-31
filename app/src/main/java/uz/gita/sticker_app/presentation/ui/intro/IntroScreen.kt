package uz.gita.sticker_app.presentation.ui.intro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import uz.gita.sticker_app.R
import uz.gita.sticker_app.databinding.ScreenIntroBinding
import uz.gita.sticker_app.presentation.presenter.IntroViewModelImpl
import uz.gita.sticker_app.utils.*

// Created by Jamshid Isoqov on 1/28/2023
@AndroidEntryPoint
class IntroScreen : Fragment(R.layout.screen_intro){

    private val adapter:IntroAdapter by lazy { IntroAdapter(requireActivity()) }

    private val viewModel:IntroViewModel by viewModels<IntroViewModelImpl>()

    private val viewBinding:ScreenIntroBinding by viewBinding()

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {
        pagerStickerIntro.adapter = adapter
        dotIndicatorIntro.attachTo(pagerStickerIntro)
        btnSkip.clicks()
            .debounce(CLICK_TIMEOUT)
            .onEach { viewModel.navigateToMain() }
            .launchIn(lifecycleScope)
        btnNext.clicks()
            .debounce(CLICK_TIMEOUT)
            .onEach { viewModel.navigateToMain() }
            .launchIn(lifecycleScope)
        pagerStickerIntro.pageCallback {
            if (it==2){
                btnNext.visible()
                btnSkip.gone()
            }else{
                btnNext.gone()
                btnSkip.visible()
            }
        }
    }
}