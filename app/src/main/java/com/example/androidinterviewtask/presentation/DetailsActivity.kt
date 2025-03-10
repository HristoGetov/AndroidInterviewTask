package com.example.androidinterviewtask.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidinterviewtask.R
import androidx.appcompat.widget.Toolbar

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val symbolTextView: TextView = findViewById(R.id.textSymbol)
        val priceChangeTextView: TextView = findViewById(R.id.textPriceChange)
        val priceChangePercentTextView: TextView = findViewById(R.id.textPriceChangePercent)

        val symbol = intent.getStringExtra("symbol") ?: "N/A"
        val priceChange = intent.getStringExtra("priceChange") ?: "N/A"
        val priceChangePercent = intent.getStringExtra("priceChangePercent") ?: "N/A"

        symbolTextView.text = symbol
        priceChangeTextView.text = priceChange
        priceChangePercentTextView.text = priceChangePercent
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}