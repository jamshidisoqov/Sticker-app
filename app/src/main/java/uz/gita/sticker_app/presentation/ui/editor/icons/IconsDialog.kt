package uz.gita.sticker_app.presentation.ui.editor.icons

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.gita.sticker_app.R
import uz.gita.sticker_app.databinding.DialogBottomIconsBinding
import uz.gita.sticker_app.domain.model.IconsData
import uz.gita.sticker_app.utils.include

// Created by Jamshid Isoqov on 1/30/2023
class IconsDialog : BottomSheetDialogFragment(R.layout.dialog_bottom_icons) {

    private var itemClickListener: ((IconsData) -> Unit)? = null

    fun setItemClickListener(block: (IconsData) -> Unit) {
        itemClickListener = block
    }

    private val viewBinding: DialogBottomIconsBinding by viewBinding()

    private val adapter: IconsAdapter by lazy(LazyThreadSafetyMode.NONE) {
        IconsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {
        listIcons.adapter = adapter
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        adapter.setItemClickListener {
            itemClickListener?.invoke(it)
        }
    }
}