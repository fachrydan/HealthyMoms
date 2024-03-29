package com.skripsi.healthymoms.tips.makanan.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class TipsEntityMakanan (
    val id: String,
    val name: String,
    val rincianKalori: String,
    val overview: String,
    val detailManfaat: String,
    val poster: Int,
    val backDrop: Int,
    val link: String,
) : Parcelable