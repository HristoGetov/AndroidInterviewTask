package com.example.androidinterviewtask.data.api

import com.example.androidinterviewtask.data.model.Crypto
import retrofit2.http.GET

interface CryptoInterface {
    @GET("/api/v3/ticker/24hr")
     suspend fun getAllCrypto(): List<Crypto>
}