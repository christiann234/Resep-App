package com.example.resepapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resepapp.adapter.ResepAdapter
import com.example.resepapp.databinding.ActivityMainBinding
import com.example.resepapp.model.Resep
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resepList: MutableList<Resep>
    private lateinit var resepAdapter: ResepAdapter
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resepList = mutableListOf()
        resepAdapter = ResepAdapter(resepList)
        dbRef = FirebaseDatabase.getInstance().getReference("resep")

        binding.recyclerViewResep.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = resepAdapter
        }

        binding.btnDaftarResep.setOnClickListener {
            startActivity(Intent(this, DaftarResepActivity::class.java))
        }

        binding.btnTambahResep.setOnClickListener {
            startActivity(Intent(this, AddResepActivity::class.java))
        }

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                resepList.clear()
                for (data in snapshot.children) {
                    val resep = data.getValue(Resep::class.java)
                    resep?.let { resepList.add(it) }
                }
                resepAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
