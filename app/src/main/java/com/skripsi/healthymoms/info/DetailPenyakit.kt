package com.skripsi.healthymoms.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.skripsi.healthymoms.R

class DetailPenyakit : AppCompatActivity() {

    private lateinit var namaPenyakitDetail : TextView
    private lateinit var descPenyakitDetail : TextView
    private lateinit var penyakitNames : String

    companion object {
        const val DATA_NAMA = "data_nama"
        const val DATA_DESC = "data_desc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_penyakit)

        penyakitNames = intent.getStringExtra(DATA_NAMA).toString()
        val penyakitDesc = intent.getStringExtra(DATA_DESC)

        if(penyakitDesc != null){
            setDetailInformation(penyakitNames, penyakitDesc)
        }
    }

    private fun setDetailInformation(penyakitName : String, penyakitDesc: String){
        namaPenyakitDetail = findViewById(R.id.nama_penyakit_detail)
        descPenyakitDetail = findViewById(R.id.desc_detail_penyakit)
        namaPenyakitDetail.text = penyakitName
        descPenyakitDetail.text = penyakitDesc

    }

}