package com.example.innerpeace.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.innerpeace.DetailKonseling
import com.example.innerpeace.Model.SesiList
import com.example.innerpeace.databinding.ItemRiwayatBinding
import com.example.innerpeace.formatDateTime
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import android.content.Context



class SesiAdapter(private val context: Context, private val ItemRiwayat: List<SesiList>) :
        RecyclerView.Adapter<SesiAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemRiwayatBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val binding = ItemRiwayatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
     return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ItemRiwayat[position]
        with(holder.binding) {
            sesikonseling.text = item.sesiKonseling
            namadokter.text = item.namaDokter
            jam.text = formatDateTime(item.Jam) // Format jam dan tanggal
        }

        // Set onClickListener untuk item
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailKonseling::class.java).apply {
                putExtra("sesiKonseling", item.sesiKonseling)
                putExtra("namaDokter", item.namaDokter)
                putExtra("jam", formatDateTime(item.Jam)) // Kirim format tanggal
            }
            context.startActivity(intent)
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