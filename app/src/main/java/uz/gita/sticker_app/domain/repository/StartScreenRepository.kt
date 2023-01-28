package uz.gita.sticker_app.domain.repository

import uz.gita.sticker_app.domain.model.StartScreen

// Created by Jamshid Isoqov on 1/28/2023
interface StartScreenRepository {
    suspend operator fun invoke(): StartScreen
}