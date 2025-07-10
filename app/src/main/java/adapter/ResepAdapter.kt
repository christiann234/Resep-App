package com.example.resepapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resepapp.databinding.ItemResepBinding
import com.example.resepapp.model.Resep

class ResepAdapter(private val list: List<Resep>) : RecyclerView.Adapter<ResepAdapter.ResepViewHolder>() {

    inner class ResepViewHolder(val binding: ItemResepBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder {
        val binding = ItemResepBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResepViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvNamaResep.text = item.nama
        holder.binding.tvBahan.text = "Bahan: ${item.bahan}"
        holder.binding.tvLangkah.text = "Langkah: ${item.langkah}"
    }

    override fun getItemCount(): Int = list.size
}
