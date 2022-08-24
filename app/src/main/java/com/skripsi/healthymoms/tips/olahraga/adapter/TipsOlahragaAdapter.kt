package com.skripsi.healthymoms.tips.olahraga.adapter

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
import com.skripsi.healthymoms.tips.olahraga.OlahragaDetailActivity
import com.skripsi.healthymoms.tips.olahraga.utils.TipsEntityOlahraga

class TipsOlahragaAdapter : RecyclerView.Adapter<TipsOlahragaAdapter.TipsViewHolder>() {

    private var olah = ArrayList<TipsEntityOlahraga>()

    fun setOlahraga(olahs: ArrayList<TipsEntityOlahraga>?){
        if (olahs.isNullOrEmpty()) return
        this.olah.clear()
        this.olah.addAll(olahs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        val itemTipsBinding = ItemRowTipsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TipsViewHolder(itemTipsBinding)
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        holder.bind(olah[position])
    }

    override fun getItemCount(): Int = olah.size

    class TipsViewHolder(private val binding: ItemRowTipsBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NewApi")
        fun bind(olahraga: TipsEntityOlahraga) {
            with(binding) {
                tvName.text = olahraga.name

                Glide.with(itemView.context)
                    .load(olahraga.poster)
                    .transform(RoundedCorners(28))
                    .into(ivPoster)

                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, olahraga.poster)

                Palette.from(bitmap).generate { palette ->
                    val defValue = itemView.resources.getColor(R.color.dark, itemView.context.theme)
                    cardItem.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, OlahragaDetailActivity::class.java)
                    intent.putExtra(OlahragaDetailActivity.EXTRA_OLAHRAGA, olahraga.id)
                    intent.putExtra(OlahragaDetailActivity.EXTRA_CATEGORY, DetailViewModel.OLAHARAGA)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}