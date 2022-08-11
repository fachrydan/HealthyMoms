package com.skripsi.healthymoms.tips

import androidx.lifecycle.ViewModel
import com.skripsi.healthymoms.tips.makanan.utils.DataTipsMakanan
import com.skripsi.healthymoms.tips.makanan.utils.TipsEntityMakanan

class DetailViewModel: ViewModel() {
    companion object {
        const val MAKANAN = "makanan"

        //SEMUA COMMENT DIBUKA JIKA MINUMAN DAN  OLAHRAGA SUDAH DI TAMBAH

        //const val MINUMAN = "minuman"
        //const val OLAHARAGA = "olahraga"
    }

    private lateinit var makanan: TipsEntityMakanan

    //private lateinit var minuman: TipsEntityMinuman

    //private lateinit var olahraga: TipsEntityOlahraga

    fun setMakanan(id: String, category: String) {
        when (category) {
            MAKANAN -> {
                for (makan in DataTipsMakanan.getTips()) {
                    if (makan.id == id) makanan = makan
                }
            }
        }
    }

    /*fun setMinuman(id: String, category: String) {
        when (category) {
            MINUMAN -> {
                for (minum in DataTipsMinuman.getTips()) {
                    if (minum.id == id) minuman = minum
                }
            }
        }
    }*/


    /*fun setOlahraga(id: String, category: String) {
        when (category) {
            OLAHARAGA -> {
                for (olah in DataTipsOlahraga.getTips()) {
                    if (olah.id == id) olahraga = olah
                }
            }
        }
    }*/

    fun getMakananDetail() = makanan

    //fun getMinumanDetail() = minuman

    //fun getOlahragaDetail() = olahraga

}