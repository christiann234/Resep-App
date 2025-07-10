package com.example.resepapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resepapp.adapter.ResepAdapter
import com.example.resepapp.databinding.ActivityDaftarResepBinding
import com.example.resepapp.model.Resep
import com.google.firebase.database.*

class DaftarResepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarResepBinding
    private lateinit var adapter: ResepAdapter
    private val resepList = mutableListOf<Resep>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarResepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ResepAdapter(resepList)
        binding.recyclerViewResep.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewResep.adapter = adapter

        val dbRef = FirebaseDatabase.getInstance("https://uas-pam-792e1-default-rtdb.asia-southeast1.firebasedatabase.app")
            .getReference("resep")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                resepList.clear()
                for (data in snapshot.children) {
                    val resep = data.getValue(Resep::class.java)
                    resep?.let { resepList.add(it) }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("DaftarResepActivity", "Error: ${error.message}")
            }
        })
    }
}
