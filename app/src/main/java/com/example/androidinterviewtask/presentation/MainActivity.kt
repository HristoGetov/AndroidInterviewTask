package com.example.androidinterviewtask.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidinterviewtask.R
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: CryptoViewModel by viewModels()
    private lateinit var adapter: CryptoRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        adapter = CryptoRecyclerAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.tickers.observe(this, Observer { tickers ->
            tickers?.let { adapter.updateData(it) }
        })

        viewModel.loadTickers()
    }
}