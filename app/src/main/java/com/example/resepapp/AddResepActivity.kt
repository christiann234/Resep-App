package com.example.resepapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.resepapp.databinding.ActivityAddResepBinding
import com.example.resepapp.model.Resep
import com.google.firebase.database.FirebaseDatabase

class AddResepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddResepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddResepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = FirebaseDatabase.getInstance("https://uas-pam-792e1-default-rtdb.asia-southeast1.firebasedatabase.app")
            .getReference("resep")


        binding.btnSimpan.setOnClickListener {
            Log.d("AddResepActivity", "TOMBOL SIMPAN DIKLIK")

            val nama = binding.etNama.text.toString().trim()
            val bahan = binding.etBahan.text.toString().trim()
            val langkah = binding.etLangkah.text.toString().trim()

            if (nama.isEmpty() || bahan.isEmpty() || langkah.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val id = db.push().key
            if (id == null) {
                Log.e("FirebaseDB", "Gagal generate ID push.")
                return@setOnClickListener
            }

            val resep = Resep(id, nama, bahan, langkah)

            db.child(id).setValue(resep)
                .addOnSuccessListener {
                    Log.d("FirebaseDB", "Resep disimpan ke Firebase.")
                    Toast.makeText(this, "Resep berhasil disimpan!", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .addOnFailureListener {
                    Log.e("FirebaseDB", "Gagal menyimpan: ${it.message}", it)
                    Toast.makeText(this, "Gagal simpan: ${it.message}", Toast.LENGTH_LONG).show()
                }
        }
    }
}