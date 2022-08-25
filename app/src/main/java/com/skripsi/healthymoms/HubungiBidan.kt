package com.skripsi.healthymoms

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar

class HubungiBidan : AppCompatActivity(), View.OnClickListener {

    private var title = "Hubungi Bidan Terdekat"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hubungi_bidan)
        setActionBarTitle(title)

        val btnBidan1: Button = findViewById(R.id.btn_bidan1)
        btnBidan1.setOnClickListener(this)

        val btnBidan2: Button = findViewById(R.id.btn_bidan2)
        btnBidan2.setOnClickListener(this)

        val btnBidan3: Button = findViewById(R.id.btn_bidan3)
        btnBidan3.setOnClickListener(this)

        val btnBidan4: Button = findViewById(R.id.btn_bidan4)
        btnBidan4.setOnClickListener(this)

        val btnBidan5: Button = findViewById(R.id.btn_bidan5)
        btnBidan5.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_bidan1 -> {
                val profileBidan1 = "https://api.whatsapp.com/send?phone=6281517984048&text=Hello Ms. Raisa, "
                val checkWhatsAppBidan1= Intent(Intent.ACTION_VIEW, Uri.parse(profileBidan1))
                startActivity(checkWhatsAppBidan1)
            }
            R.id.btn_bidan2 -> {
                val profileBidan2 = "https://api.whatsapp.com/send?phone=6285885927426&text=Hello Ms. Isyana, "
                val checkWhatsAppBidan2= Intent(Intent.ACTION_VIEW, Uri.parse(profileBidan2))
                startActivity(checkWhatsAppBidan2)
            }
            R.id.btn_bidan3-> {
                val profileBidan3= "https://api.whatsapp.com/send?phone=6281517984048&text=Hello Ms. Angie, "
                val checkWhatsAppBidan3 = Intent(Intent.ACTION_VIEW, Uri.parse(profileBidan3))
                startActivity(checkWhatsAppBidan3)
            }
            R.id.btn_bidan4-> {
                val profileBidan4= "https://api.whatsapp.com/send?phone=6281517984048&text=Hello Ms. Pevita, "
                val checkWhatsAppBidan4 = Intent(Intent.ACTION_VIEW, Uri.parse(profileBidan4))
                startActivity(checkWhatsAppBidan4)
            }
            R.id.btn_bidan5-> {
                val profileBidan5= "https://api.whatsapp.com/send?phone=6281517984048&text=Hello Ms. Anya, "
                val checkWhatsAppBidan5 = Intent(Intent.ACTION_VIEW, Uri.parse(profileBidan5))
                startActivity(checkWhatsAppBidan5)
            }
        }
    }

    private fun setActionBarTitle(title: String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }


}