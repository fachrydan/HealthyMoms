package com.skripsi.healthymoms.tips.makanan.adapter

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
import com.skripsi.healthymoms.tips.makanan.MakananDetailActivity
import com.skripsi.healthymoms.tips.DetailViewModel.Companion.MAKANAN
import com.skripsi.healthymoms.tips.makanan.utils.TipsEntityMakanan

class TipsMakananAdapter: RecyclerView.Adapter<TipsMakananAdapter.TipsViewHolder>() {

    private var food = ArrayList<TipsEntityMakanan>()

    fun setMakanan(foods: ArrayList<TipsEntityMakanan>?){
        if (foods.isNullOrEmpty()) return
        this.food.clear()
        this.food.addAll(foods)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        val itemMovieBinding = ItemRowTipsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TipsViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        holder.bind(food[position])
    }

    override fun getItemCount(): Int = food.size

    class TipsViewHolder(private val binding: ItemRowTipsBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NewApi")
        fun bind(makanan: TipsEntityMakanan) {
            with(binding) {
                tvName.text = makanan.name
                //tvSpecies.text = animal.species

                Glide.with(itemView.context)
                    .load(makanan.poster)
                    .transform(RoundedCorners(28))
                    .into(ivPoster)

                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, makanan.poster)

                Palette.from(bitmap).generate { palette ->
                    val defValue = itemView.resources.getColor(R.color.dark, itemView.context.theme)
                    cardItem.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MakananDetailActivity::class.java)
                    intent.putExtra(MakananDetailActivity.EXTRA_MAKANAN, makanan.id)
                    intent.putExtra(MakananDetailActivity.EXTRA_CATEGORY, MAKANAN)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}