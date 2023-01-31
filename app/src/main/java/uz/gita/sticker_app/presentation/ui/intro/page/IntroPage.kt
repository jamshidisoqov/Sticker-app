package uz.gita.sticker_app.presentation.ui.intro.page

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.sticker_app.R
import uz.gita.sticker_app.databinding.PageIntroBinding
import uz.gita.sticker_app.utils.include

// Created by Jamshid Isoqov on 1/28/2023
@AndroidEntryPoint
class IntroPage : Fragment(R.layout.page_intro) {
    private val viewBinding: PageIntroBinding by viewBinding()
    private val list = listOf(R.drawable.intro1, R.drawable.intro2, R.drawable.intro3)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {
        val currentPagePosition = requireArguments().getInt("pos", 0)
        imageIntroPage.setImageResource(list[currentPagePosition])
        tvIntroPage.text = resources.getStringArray(R.array.intro_array)[currentPagePosition]
    }
}