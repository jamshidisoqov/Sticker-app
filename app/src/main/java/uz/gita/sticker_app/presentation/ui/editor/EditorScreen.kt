package uz.gita.sticker_app.presentation.ui.editor

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import uz.gita.sticker_app.R
import uz.gita.sticker_app.databinding.ItemFeatureBinding
import uz.gita.sticker_app.databinding.ScreenEditorBinding
import uz.gita.sticker_app.presentation.ui.editor.icons.IconsDialog
import uz.gita.sticker_app.utils.CLICK_TIMEOUT
import uz.gita.sticker_app.utils.include

// Created by Jamshid Isoqov on 1/30/2023
@AndroidEntryPoint
class EditorScreen : Fragment(R.layout.screen_editor) {

    private val viewBinding: ScreenEditorBinding by viewBinding()
    private val args: EditorScreenArgs by navArgs()

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {
        val uri = args.uri
        if (uri != null)
            viewBinding.imageEditor.setImageURI(Uri.parse(uri))

        imageIcons.clicks()
            .debounce(CLICK_TIMEOUT)
            .onEach {
                val iconsDialog = IconsDialog()
                iconsDialog.setItemClickListener {
                    addIcon(it.icon)
                }
                iconsDialog.show(childFragmentManager, "icons")
            }.launchIn(lifecycleScope)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun addIcon(icon: Int) {
        val iconBinding = ItemFeatureBinding.inflate(layoutInflater)
        iconBinding.apply {
            imageFeature.setImageResource(icon)
            viewBinding.editorView.addView(root)
            root.apply {
                this.x = (viewBinding.editorView.width / 2).toFloat()
                this.y = (viewBinding.editorView.height / 2).toFloat()
                setOnTouchListener { _, event ->
                    when (event.action) {
                        MotionEvent.ACTION_DOWN -> {

                        }
                        MotionEvent.ACTION_MOVE -> {

                        }
                    }
                    false
                }
            }

        }
    }
}