package com.skripsi.healthymoms.tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skripsi.healthymoms.R

class TipsMakanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips_makanan)

        supportActionBar?.hide()
    }
}