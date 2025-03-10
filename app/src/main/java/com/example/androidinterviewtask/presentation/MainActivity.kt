package com.example.androidinterviewtask.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidinterviewtask.R
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: CryptoViewModel by viewModels()
    private lateinit var adapter: CryptoRecyclerAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        adapter = CryptoRecyclerAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.cryptos.observe(this, Observer { cryptos ->
            cryptos?.let {
                adapter.updateData(it)
                progressBar.visibility = View.GONE
            }
        })

        viewModel.loadCryptos()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                if (layoutManager.findFirstVisibleItemPosition() == 0 && dy < 0) {
                    Log.e("Log","🔄 Reloading data from API...")
                    progressBar.visibility = View.VISIBLE
                    viewModel.reloadCryptoFromApi()
                }
            }
        })

    }
}