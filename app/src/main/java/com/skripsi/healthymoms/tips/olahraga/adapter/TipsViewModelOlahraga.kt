package com.skripsi.healthymoms.tips.olahraga.adapter

import androidx.lifecycle.ViewModel
import com.skripsi.healthymoms.tips.olahraga.utils.DataTipsOlahraga

class TipsViewModelOlahraga : ViewModel() {
    fun getTips() = DataTipsOlahraga.getTips()
}