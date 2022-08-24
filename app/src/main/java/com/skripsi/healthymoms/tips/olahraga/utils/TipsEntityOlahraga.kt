package com.skripsi.healthymoms.tips.olahraga.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class TipsEntityOlahraga (
    val id: String,
    val name: String,
    val rincianKalori: String,
    val overview: String,
    val stepByStep: String,
    val poster: Int,
    val backDrop: Int,
    val link: String,
) : Parcelable