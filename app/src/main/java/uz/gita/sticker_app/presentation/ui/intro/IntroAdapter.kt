package uz.gita.sticker_app.presentation.ui.intro

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.sticker_app.presentation.ui.intro.page.IntroPage

// Created by Jamshid Isoqov on 1/28/2023
class IntroAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        IntroPage().apply { arguments = bundleOf("pos" to position) }
}