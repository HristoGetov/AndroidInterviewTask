package com.example.androidinterviewtask.data.repositories

import android.content.Context
import android.util.Log
import com.example.androidinterviewtask.data.database.CryptoDatabase
import com.example.androidinterviewtask.data.model.Crypto
import com.example.androidinterviewtask.data.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoRepository(context: Context) {
    private val cryptoDao = CryptoDatabase.getDatabase(context).tickerDao()
    suspend fun fetchCryptoFromApi(): List<Crypto>? {
        return try {
            val crypto = withContext(Dispatchers.IO) {
                RetrofitClient.instance.getAllCrypto()
            }
            if (crypto.isNotEmpty()) {
                storeCryptoInDatabase(crypto)
            }
            crypto
        } catch (e: Exception) {
            Log.e("Error", e.toString())
            null
        }
    }
    suspend fun storeCryptoInDatabase(tickers: List<Crypto>) {
        cryptoDao.clearCrypto()
        cryptoDao.insertCrypto(tickers)
    }

    suspend fun getCryptoFromDatabase(): List<Crypto> {
        return cryptoDao.getAllCrypto()
    }
}