package com.skripsi.healthymoms.tips.minuman.adapter

import androidx.lifecycle.ViewModel
import com.skripsi.healthymoms.tips.minuman.utils.DataTipsMinuman

class TipsViewModelMinuman : ViewModel() {
    fun getTips() = DataTipsMinuman.getTips()
}