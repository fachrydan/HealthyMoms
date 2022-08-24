package com.skripsi.healthymoms.tips.olahraga.adapter

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.skripsi.healthymoms.databinding.FragmentTipsOlahragaBinding


class TipsFragmentOlahraga : Fragment() {

    private lateinit var fragmentOlahragaBinding: FragmentTipsOlahragaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentOlahragaBinding = FragmentTipsOlahragaBinding.inflate(layoutInflater, container, false)
        return fragmentOlahragaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TipsViewModelOlahraga::class.java]
            val olah = viewModel.getTips()

            val olahragaAdapter = TipsOlahragaAdapter()
            olahragaAdapter.setOlahraga(olah)

            val marginVertical = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

            with(fragmentOlahragaBinding.rvTipsOlahraga) {
                addItemDecoration(MarginItemDecorationOlahraga(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = olahragaAdapter
            }
        }
    }
}