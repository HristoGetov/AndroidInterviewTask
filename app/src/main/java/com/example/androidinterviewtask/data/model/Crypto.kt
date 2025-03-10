package com.example.androidinterviewtask.data.model

data class Crypto(
    val symbol: String,
    val priceChange: String,
    val priceChangePercent: String,
    val bidPrice: String,
    val bidQty: String,
    val askPrice: String,
    val askQty: String
)
