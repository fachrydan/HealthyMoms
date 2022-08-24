package com.skripsi.healthymoms.tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.skripsi.healthymoms.R
import com.skripsi.healthymoms.tips.makanan.adapter.TipsFragmentMakanan
import com.skripsi.healthymoms.tips.makanan.adapter.ViewpagerAdapterMakanan
import kotlinx.android.synthetic.main.activity_tips_makanan.*

class TipsMakanan : AppCompatActivity() {
    private var title = "SARAN MAKANAN BUAT MOM'S"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips_makanan)

        setActionBarTitle(title)
        setViewPager()
    }

    private fun setViewPager() {
        val fragmentList = listOf(TipsFragmentMakanan())
        viewpager_makanan.adapter = ViewpagerAdapterMakanan(fragmentList, this.supportFragmentManager, lifecycle)
    }


    private fun setActionBarTitle(title: String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }

}