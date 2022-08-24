package com.skripsi.healthymoms.tips.minuman.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.skripsi.healthymoms.R
import com.skripsi.healthymoms.databinding.ItemRowTipsBinding
import com.skripsi.healthymoms.tips.DetailViewModel
import com.skripsi.healthymoms.tips.minuman.MinumanDetailActivity
import com.skripsi.healthymoms.tips.minuman.utils.TipsEntityMinuman

class TipsMinumanAdapter : RecyclerView.Adapter<TipsMinumanAdapter.TipsViewHolder>() {

    private var drink = ArrayList<TipsEntityMinuman>()

    fun setMinuman(drinks: ArrayList<TipsEntityMinuman>?){
        if (drinks.isNullOrEmpty()) return
        this.drink.clear()
        this.drink.addAll(drinks)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        val itemTipsBinding = ItemRowTipsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TipsViewHolder(itemTipsBinding)
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        holder.bind(drink[position])
    }

    override fun getItemCount(): Int = drink.size

    class TipsViewHolder(private val binding: ItemRowTipsBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NewApi")
        fun bind(minuman: TipsEntityMinuman) {
            with(binding) {
                tvName.text = minuman.name

                Glide.with(itemView.context)
                    .load(minuman.poster)
                    .transform(RoundedCorners(28))
                    .into(ivPoster)

                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, minuman.poster)

                Palette.from(bitmap).generate { palette ->
                    val defValue = itemView.resources.getColor(R.color.dark, itemView.context.theme)
                    cardItem.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MinumanDetailActivity::class.java)
                    intent.putExtra(MinumanDetailActivity.EXTRA_MINUMAN, minuman.id)
                    intent.putExtra(MinumanDetailActivity.EXTRA_CATEGORY, DetailViewModel.MINUMAN)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}