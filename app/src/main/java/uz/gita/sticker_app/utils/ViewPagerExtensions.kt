package uz.gita.sticker_app.utils

import androidx.viewpager2.widget.ViewPager2

// Created by Jamshid Isoqov on 1/29/2023

fun ViewPager2.pageCallback(block:(Int)->Unit){
    this.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            block.invoke(position)
        }
    })
}