package com.example.androidinterviewtask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_table")
data class Crypto(
    @PrimaryKey val symbol: String,
    val priceChange: String,
    val priceChangePercent: String,
    val bidPrice: String,
    val bidQty: String,
    val askPrice: String,
    val askQty: String
)
