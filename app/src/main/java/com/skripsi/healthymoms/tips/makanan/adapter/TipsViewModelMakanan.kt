package com.skripsi.healthymoms.tips.makanan.adapter

import androidx.lifecycle.ViewModel
import com.skripsi.healthymoms.tips.makanan.utils.DataTipsMakanan

class TipsViewModelMakanan: ViewModel() {
    fun getTips() = DataTipsMakanan.getTips()
}