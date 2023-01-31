package uz.gita.sticker_app.presentation.ui.editor.icons

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.sticker_app.R
import uz.gita.sticker_app.databinding.ListItemIconsBinding
import uz.gita.sticker_app.domain.model.IconsData
import uz.gita.sticker_app.utils.include
import uz.gita.sticker_app.utils.inflate

// Created by Jamshid Isoqov on 1/30/2023

private val iconsDataCallback = object : DiffUtil.ItemCallback<IconsData>() {
    override fun areItemsTheSame(oldItem: IconsData, newItem: IconsData): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: IconsData, newItem: IconsData): Boolean =
        oldItem.icon == newItem.icon

}

class IconsAdapter : ListAdapter<IconsData, IconsAdapter.ViewHolder>(iconsDataCallback) {

    private var itemClickListener: ((IconsData)->Unit)? = null

    fun setItemClickListener(block:(IconsData)->Unit){
        itemClickListener = block
    }

    inner class ViewHolder(private val binding: ListItemIconsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClickListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun onBind() = binding.include {
            val data = getItem(absoluteAdapterPosition)
            imageIcon.setImageResource(data.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListItemIconsBinding.bind(parent.inflate(R.layout.list_item_icons)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()
}