package com.skripsi.healthymoms.info.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.skripsi.healthymoms.info.DetailPenyakit
import com.skripsi.healthymoms.R
import com.skripsi.healthymoms.info.utils.Penyakit

class ListPenyakitAdapter (private val listPenyakit: ArrayList<Penyakit>) : RecyclerView.Adapter<ListPenyakitAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_penyakit, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val penyakit = listPenyakit[position]

        holder.tvName.text = penyakit.name
        holder.tvDetail.text = penyakit.detail

        holder.btnLihatDetail.setOnClickListener {
            val context= holder.btnLihatDetail.context
            val mountainDetailActivity= Intent(context, DetailPenyakit::class.java)
            mountainDetailActivity.putExtra(DetailPenyakit.DATA_NAMA, penyakit.name)
            mountainDetailActivity.putExtra(DetailPenyakit.DATA_DESC, penyakit.desc)
            context.startActivity(mountainDetailActivity)
        }
    }

    override fun getItemCount(): Int {
        return listPenyakit.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_penyakit)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_detail_penyakit)
        var btnLihatDetail: CardView= itemView.findViewById(R.id.card_lihat_detail)
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Penyakit)
    }
}