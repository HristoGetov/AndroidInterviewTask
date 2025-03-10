package com.example.androidinterviewtask.data.retrofit

import com.example.androidinterviewtask.data.api.CryptoInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api2.binance.com/api/v3/"
    val instance: CryptoInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoInterface::class.java)
    }
}