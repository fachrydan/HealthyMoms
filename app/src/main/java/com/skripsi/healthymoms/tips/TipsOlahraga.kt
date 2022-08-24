package com.skripsi.healthymoms.tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.skripsi.healthymoms.R
import com.skripsi.healthymoms.tips.olahraga.adapter.TipsFragmentOlahraga
import com.skripsi.healthymoms.tips.olahraga.adapter.ViewpagerAdapterOlahraga
import kotlinx.android.synthetic.main.activity_tips_olahraga.*


class TipsOlahraga : AppCompatActivity() {

    private var title = "SARAN OLAHRAGA BUAT MOM'S"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips_olahraga)

        setActionBarTitle(title)
        setViewPager()
    }


    private fun setViewPager() {
        val fragmentList = listOf(TipsFragmentOlahraga())
        viewpager_olahraga.adapter = ViewpagerAdapterOlahraga(fragmentList, this.supportFragmentManager, lifecycle)
    }

    private fun setActionBarTitle(title: String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }
}