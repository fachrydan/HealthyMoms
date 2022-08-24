package com.skripsi.healthymoms.tips

import androidx.lifecycle.ViewModel
import com.skripsi.healthymoms.tips.makanan.utils.DataTipsMakanan
import com.skripsi.healthymoms.tips.makanan.utils.TipsEntityMakanan
import com.skripsi.healthymoms.tips.minuman.utils.DataTipsMinuman
import com.skripsi.healthymoms.tips.minuman.utils.TipsEntityMinuman
import com.skripsi.healthymoms.tips.olahraga.utils.DataTipsOlahraga
import com.skripsi.healthymoms.tips.olahraga.utils.TipsEntityOlahraga

class DetailViewModel: ViewModel() {
    companion object {
        const val MAKANAN = "makanan"
        const val MINUMAN = "minuman"
        const val OLAHARAGA = "olahraga"
    }

    private lateinit var makanan: TipsEntityMakanan
    private lateinit var minuman: TipsEntityMinuman
    private lateinit var olahraga: TipsEntityOlahraga

    fun setMakanan(id: String, category: String) {
        when (category) {
            MAKANAN -> {
                for (makan in DataTipsMakanan.getTips()) {
                    if (makan.id == id) makanan = makan
                }
            }
        }
    }

    fun setMinuman(id: String, category: String) {
        when (category) {
            MINUMAN -> {
                for (minum in DataTipsMinuman.getTips()) {
                    if (minum.id == id) minuman = minum
                }
            }
        }
    }


    fun setOlahraga(id: String, category: String) {
        when (category) {
            OLAHARAGA -> {
                for (olah in DataTipsOlahraga.getTips()) {
                    if (olah.id == id) olahraga = olah
                }
            }
        }
    }

    fun getMakananDetail() = makanan
    fun getMinumanDetail() = minuman
    fun getOlahragaDetail() = olahraga
}