package com.example.innerpeace

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.innerpeace.databinding.ActivityListSesiKonselingBinding
import java.util.Calendar

class ListSesiKonseling : AppCompatActivity() {

    private lateinit var binding: ActivityListSesiKonselingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inisialisasi View Binding
        binding = ActivityListSesiKonselingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data untuk RecyclerView
        val ItemRiwayat = listOf(
            SesiList("Konseling Individu", "Dr. Andi", Calendar.getInstance().apply {
                set(2025, Calendar.JANUARY, 12, 10, 0)
            }.time),
            SesiList("Konseling Kelompok", "Dr. Budi", Calendar.getInstance().apply {
                set(2025, Calendar.JANUARY, 12, 14, 0)
            }.time),
            SesiList("Konseling Keluarga", "Dr. Clara", Calendar.getInstance().apply {
                set(2025, Calendar.JANUARY, 12, 16, 0)
            }.time)
        )

        // Atur RecyclerView
        binding.rvRiwayatkonseling.layoutManager = LinearLayoutManager(this)
        binding.rvRiwayatkonseling.adapter = SesiAdapter(ItemRiwayat)
    }
}
