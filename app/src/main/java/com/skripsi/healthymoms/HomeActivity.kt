package com.skripsi.healthymoms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.skripsi.healthymoms.info.InfoPenyakit

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()
        val buttonTips : CardView = findViewById(R.id.btn_tips)
        val buttonInformasi : CardView = findViewById(R.id.btn_informasi)
        val buttonPrediksiKelahiran : CardView = findViewById(R.id.btn_prediksiKelahiran)
        val buttonHubungiBidan : CardView = findViewById(R.id.btn_hubungiBidan)

        val buttonAbout : CardView = findViewById(R.id.btn_about)

        buttonTips.setOnClickListener(this)
        buttonInformasi.setOnClickListener(this)
        buttonPrediksiKelahiran.setOnClickListener(this)
        buttonHubungiBidan.setOnClickListener(this)

        buttonAbout.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_tips -> {
                val homeAct = Intent(this@HomeActivity, Tips::class.java)
                startActivity(homeAct)
            }
            R.id.btn_informasi -> {
                val homeAct = Intent(this@HomeActivity, InfoPenyakit::class.java)
                startActivity(homeAct)
            }
            R.id.btn_prediksiKelahiran -> {
                val homeAct = Intent(this@HomeActivity, PrediksiTglLahir::class.java)
                startActivity(homeAct)
            }
            R.id.btn_hubungiBidan -> {
                val homeAct = Intent(this@HomeActivity, AboutDeveloper::class.java)
                startActivity(homeAct)
            }

            R.id.btn_about -> {
                val homeAct = Intent(this@HomeActivity, AboutDeveloper::class.java)
                startActivity(homeAct)
            }

        }

    }

}