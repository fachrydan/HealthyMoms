package com.skripsi.healthymoms.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skripsi.healthymoms.R
import com.skripsi.healthymoms.info.adapter.ListPenyakitAdapter
import com.skripsi.healthymoms.info.utils.DataPenyakit
import com.skripsi.healthymoms.info.utils.Penyakit

class InfoPenyakit : AppCompatActivity() {
    private lateinit var rvPenyakit: RecyclerView
    private var title = "PENYAKIT & SOLUSI UNTUK MOM'S"
    private var listMain: ArrayList<Penyakit> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBarTitle(title)
        setContentView(R.layout.activity_info_penyakit)

        rvPenyakit= findViewById(R.id.rv_penyakit)
        rvPenyakit.setHasFixedSize(true)

        listMain.addAll(DataPenyakit.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvPenyakit.layoutManager = LinearLayoutManager(this)
        val listPenyakitAdapter = ListPenyakitAdapter(listMain)
        rvPenyakit.adapter = listPenyakitAdapter
    }

    private fun setActionBarTitle(title: String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }

}