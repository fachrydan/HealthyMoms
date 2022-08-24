package com.skripsi.healthymoms.tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.skripsi.healthymoms.R
import com.skripsi.healthymoms.tips.minuman.adapter.TipsFragmentMinuman
import com.skripsi.healthymoms.tips.minuman.adapter.ViewpagerAdapterMinuman
import kotlinx.android.synthetic.main.activity_tips_minuman.*

class TipsMinuman : AppCompatActivity() {
    private var title = "SARAN MINUMAN BUAT MOM'S"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips_minuman)

        setActionBarTitle(title)
        setViewPager()

    }

    private fun setViewPager() {
        val fragmentList = listOf(TipsFragmentMinuman())
        viewpager_minuman.adapter = ViewpagerAdapterMinuman(fragmentList, this.supportFragmentManager, lifecycle)
    }

    private fun setActionBarTitle(title: String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }

}