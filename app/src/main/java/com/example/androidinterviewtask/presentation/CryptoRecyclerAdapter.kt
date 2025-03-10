package com.example.androidinterviewtask.presentation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidinterviewtask.R
import com.example.androidinterviewtask.data.model.Crypto

class CryptoRecyclerAdapter (private var tickers: List<Crypto>) :
    RecyclerView.Adapter<CryptoRecyclerAdapter.TickerViewHolder>() {

    class TickerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val symbolTextView: TextView = itemView.findViewById(R.id.textSymbol)
        val priceChangeTextView: TextView = itemView.findViewById(R.id.textPriceChange)
        val bidAskTextView: TextView = itemView.findViewById(R.id.textBidAsk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.crypto_item, parent, false)
        return TickerViewHolder(view)
    }

    override fun onBindViewHolder(holder: TickerViewHolder, position: Int) {
        val ticker = tickers[position]
        holder.symbolTextView.text = "${ticker.symbol}:"
        holder.priceChangeTextView.text = "${ticker.priceChangePercent}%"
        holder.bidAskTextView.text = "${ticker.bidPrice}/${ticker.askPrice}"

        holder.itemView.setOnClickListener {
            val context = it.context
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("symbol", ticker.symbol)
                putExtra("priceChange", ticker.priceChangePercent)
                putExtra("priceChangePercent", ticker.priceChange)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = tickers.size

    fun updateData(newTickers: List<Crypto>) {
        tickers = newTickers
        notifyDataSetChanged()
    }
}