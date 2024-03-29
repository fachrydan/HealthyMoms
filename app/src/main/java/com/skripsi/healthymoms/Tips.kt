package com.skripsi.healthymoms

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.skripsi.healthymoms.tips.TipsMakanan
import com.skripsi.healthymoms.tips.TipsMinuman
import com.skripsi.healthymoms.tips.TipsOlahraga

class Tips : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        supportActionBar?.hide()
        val buttonTipsMakanan : CardView  = findViewById(R.id.btnT_Makanan)
        val buttonTipsMinuman : CardView  = findViewById(R.id.btnT_Minuman)
        val buttonTipsOlahraga : CardView  = findViewById(R.id.btnT_Olahraga)

        buttonTipsMakanan.setOnClickListener(this)
        buttonTipsMinuman.setOnClickListener(this)
        buttonTipsOlahraga.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnT_Makanan -> {
                val tipsAct = Intent(this@Tips, TipsMakanan::class.java)
                startActivity(tipsAct)
            }
            R.id.btnT_Minuman -> {
                val tipsAct = Intent(this@Tips, TipsMinuman::class.java)
                startActivity(tipsAct)
            }
            R.id.btnT_Olahraga -> {
                val tipsAct = Intent(this@Tips, TipsOlahraga::class.java)
                startActivity(tipsAct)
            }
        }
    }

}