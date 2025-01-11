package com.example.innerpeace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.innerpeace.databinding.ItemRiwayatBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SesiAdapter (private val ItemRiwayat: List<SesiList>) :
        RecyclerView.Adapter<SesiAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemRiwayatBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SesiAdapter.ViewHolder {
     val binding = ItemRiwayatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
     return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SesiAdapter.ViewHolder, position: Int) {
        with(holder){
            with(ItemRiwayat[position]){
                binding.sesikonseling.text = this.sesiKonseling
                binding.namadokter.text = this.namaDokter
                binding.jam.text= formatDateTime(this.Jam)
            }
        }
    }
    fun Date.formatToDateTimeString(): String {
        val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
        return dateFormat.format(this)
    }
    override fun getItemCount(): Int {
        return ItemRiwayat.size
    }

}