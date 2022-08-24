package com.skripsi.healthymoms.tips.makanan.adapter

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.skripsi.healthymoms.databinding.FragmentTipsMakananBinding

class TipsFragmentMakanan : Fragment() {

    private lateinit var fragmentMakananBinding: FragmentTipsMakananBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMakananBinding = FragmentTipsMakananBinding.inflate(layoutInflater, container, false)
        return fragmentMakananBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TipsViewModelMakanan::class.java]
            val foods = viewModel.getTips()

            val foodAdapter = TipsMakananAdapter()
            foodAdapter.setMakanan(foods)

            val marginVertical = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

            with(fragmentMakananBinding.rvTipsMakanan) {
                addItemDecoration(MarginItemDecorationMakanan(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = foodAdapter
            }
        }
    }
}