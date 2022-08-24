package com.skripsi.healthymoms.tips.minuman

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.skripsi.healthymoms.R
import com.skripsi.healthymoms.databinding.ActivityDetailMinumanBinding
import com.skripsi.healthymoms.tips.DetailViewModel
import com.skripsi.healthymoms.tips.minuman.utils.TipsEntityMinuman
import kotlin.math.abs

class MinumanDetailActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

    companion object {
        const val EXTRA_MINUMAN = "extra_minuman"
        const val EXTRA_CATEGORY = "extra_category"
    }

    private lateinit var detailBinding: ActivityDetailMinumanBinding
    private val percentageToShowImage = 20
    private var mMaxScrollSize = 0
    private var mIsImageHidden = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailMinumanBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.hide()

        detailBinding.toolbar.setNavigationOnClickListener { onBackPressed() }
        detailBinding.appbar.addOnOffsetChangedListener(this)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_MINUMAN)
            val dataCategory = extras.getString(EXTRA_CATEGORY)

            if (dataId != null && dataCategory != null) {
                viewModel.setMinuman(dataId, dataCategory)
                val drink = viewModel.getMinumanDetail()
                populateDataDetail(drink)
            }
        }
    }

    private fun populateDataDetail(data: TipsEntityMinuman) {

        detailBinding.collapsing.title = data.name
        detailBinding.tvDetailOverview.text = data.overview
        detailBinding.tvDetailRincianKalori.text = data.rincianKalori
        detailBinding.tvDetailManfaat.text = data.detailManfaat

        Glide.with(this)
            .load(data.poster)
            .into(detailBinding.ivDetail)

        detailBinding.ivDetail.tag = data.poster
        setColorByPalette(data.poster)

        Glide.with(this)
            .load(data.backDrop)
            .into(detailBinding.ivBackdrop)

        detailBinding.ivBackdrop.tag = data.backDrop
        detailBinding.btnWeb.setOnClickListener{
            val checkLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data.link))
            startActivity(checkLinkIntent)
        }
    }


    @SuppressLint("NewApi")
    private fun setColorByPalette(poster: Int) {
        val bitmap = BitmapFactory.decodeResource(resources, poster)

        Palette.from(bitmap).generate { palette ->
            val defValue = resources.getColor(R.color.dark, theme)
            detailBinding.cardDetail.setCardBackgroundColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            detailBinding.collapsing.setContentScrimColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            window.statusBarColor = palette?.getDarkMutedColor(defValue) ?: defValue
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBarLayout!!.totalScrollRange

        val currentScrollPercentage: Int = (abs(verticalOffset) * 100 / mMaxScrollSize)

        if (currentScrollPercentage >= percentageToShowImage) {
            if (!mIsImageHidden) {
                mIsImageHidden = true
            }
        }

        if (currentScrollPercentage < percentageToShowImage) {
            if (mIsImageHidden) {
                mIsImageHidden = false
            }
        }
    }

}