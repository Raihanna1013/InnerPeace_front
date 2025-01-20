package com.example.innerpeace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.innerpeace.databinding.ActivityDetailKonselingBinding

class DetailKonseling : AppCompatActivity() {

    private lateinit var binding : ActivityDetailKonselingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKonselingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sesiKonseling = intent.getStringExtra("sesiKonseling")
        val namaDokter = intent.getStringExtra("namaDokter")
        val jam = intent.getStringExtra("Jam")

        val buttonKembali: ImageButton = findViewById(R.id.button_kembali)
        val textNamaDokter: TextView = findViewById(R.id.nama_dokter)
        val textKeahlian: TextView = findViewById(R.id.keahlian)
        val textJam: TextView = findViewById(R.id.textjam)
        val textDeskripsi: TextView = findViewById(R.id.tv_deskripsi)
        val btnMulaiSekarang: Button = findViewById(R.id.btn_mulai_sekarang)

        textNamaDokter.text = namaDokter
        textKeahlian.text = sesiKonseling
        textJam.text = jam
        textDeskripsi.text = "Sesi ini untuk konseling ya"


        buttonKembali.setOnClickListener{
            val intent = Intent(this, ListSesiKonseling::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        btnMulaiSekarang.setOnClickListener {
            showToast("Sesi $sesiKonseling bersama $namaDokter dimulai.")
        }
       }

    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
}