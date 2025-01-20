package com.example.innerpeace

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.innerpeace.databinding.ActivityDetailKonselingBinding
import com.example.innerpeace.databinding.ActivityDetailKonselingRiwayatBinding

class DetailKonselingRiwayat : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKonselingRiwayatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_konseling_riwayat)
        binding = ActivityDetailKonselingRiwayatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sesiKonseling = intent.getStringExtra("sesiKonseling")
        val namaDokter = intent.getStringExtra("namaDokter")
        val jam = intent.getStringExtra("Jam")

        val btnKembali : ImageView = findViewById(R.id.button_kembali)
        val textNamaDokter: TextView = findViewById(R.id.nama_dokter)
        val textKeahlian: TextView = findViewById(R.id.keahlian)
        val textJam: TextView = findViewById(R.id.textjam)


        textNamaDokter.text = namaDokter
        textKeahlian.text = sesiKonseling
        textJam.text = jam

        btnKembali.setOnClickListener{
            val intent = Intent(this, ListSesiKonseling::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}