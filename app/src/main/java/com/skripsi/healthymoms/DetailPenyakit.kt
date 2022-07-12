package com.skripsi.healthymoms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.skripsi.healthymoms.utils.DataPenyakit

class DetailPenyakit : AppCompatActivity() {

    //private lateinit var detailFotoGunung : ImageView
    private lateinit var namaPenyakitDetail : TextView

    private lateinit var descPenyakitDetail : TextView
    //private lateinit var statusDetail : TextView
    //private lateinit var ketinggianDetail : TextView
    //private lateinit var descGunungDetail : TextView
    //private lateinit var btnGoBack : Button
    //private lateinit var btnCheckMaps : Button

    private lateinit var penyakitNames : String

    companion object {
        const val DATA_NAMA = "data_nama"
        const val DATA_DESC = "data_desc"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_detail_penyakit)

        penyakitNames = intent.getStringExtra(DATA_NAMA).toString()
        val penyakitDesc = intent.getStringExtra(DATA_DESC)

        /*val mountainImage = intent.getIntExtra(DATA_GAMBAR, 0)
        detailFotoGunung = findViewById(R.id.detail_foto_gunung)
        detailFotoGunung.setImageResource(mountainImage)*/

        if(penyakitDesc != null){
            setDetailInformation(penyakitNames, penyakitDesc)
        }

        //btnGoBack = findViewById(R.id.btn_back_home)
        //btnCheckMaps = findViewById(R.id.btn_look_maps)

        //btnGoBack.setOnClickListener(this)
        //btnCheckMaps.setOnClickListener(this)
    }

    private fun setDetailInformation(penyakitName : String, penyakitDesc: String){
        namaPenyakitDetail = findViewById(R.id.nama_penyakit_detail)
        descPenyakitDetail = findViewById(R.id.desc_detail_penyakit)
        //ketinggianDetail = findViewById(R.id.ketinggial_tabel)
        //descGunungDetail = findViewById(R.id.desc_detail)
        //statusDetail = findViewById(R.id.status_tabel)

        namaPenyakitDetail.text = penyakitName.toString()
        descPenyakitDetail.text = penyakitDesc.toString()

        //ketinggianDetail.text = DataGunung.ketingganGunung[penyakitName].toString()

        //descGunungDetail.text = DataGunung.descGunung[penyakitName].toString()

        /*statusDetail.text = when{
            mountainName in DataGunung.mountainStatus["aktif"]!! -> "Aktif"
            mountainName in DataGunung.mountainStatus["tidak aktif"]!! -> "Tidak Aktif"
            else -> "Data Not Available"
        }*/
    }

}