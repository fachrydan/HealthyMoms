package com.skripsi.healthymoms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.skripsi.healthymoms.info.InfoPenyakit
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        btnLogout.setOnClickListener{
            auth.signOut()
            Intent(this@HomeActivity, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

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
                val homeAct = Intent(this@HomeActivity, HubungiBidan::class.java)
                startActivity(homeAct)
            }
            R.id.btn_about -> {
                val homeAct = Intent(this@HomeActivity, AboutDeveloper::class.java)
                startActivity(homeAct)
            }
        }
    }
}