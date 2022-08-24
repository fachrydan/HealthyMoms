package com.skripsi.healthymoms.tips.minuman.adapter

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.skripsi.healthymoms.databinding.FragmentTipsMinumanBinding


class TipsFragmentMinuman : Fragment() {

    private lateinit var fragmentMinumanBinding: FragmentTipsMinumanBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMinumanBinding = FragmentTipsMinumanBinding.inflate(layoutInflater, container, false)
        return fragmentMinumanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TipsViewModelMinuman::class.java]
            val drinks = viewModel.getTips()

            val drinkAdapter = TipsMinumanAdapter()
            drinkAdapter.setMinuman(drinks)

            val marginVertical = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

            with(fragmentMinumanBinding.rvTipsMinuman) {
                addItemDecoration(MarginItemDecorationMinuman(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = drinkAdapter
            }
        }
    }
}