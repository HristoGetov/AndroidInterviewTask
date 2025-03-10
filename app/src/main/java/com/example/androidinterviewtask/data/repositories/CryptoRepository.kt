package com.example.androidinterviewtask.data.repositories

import com.example.androidinterviewtask.data.model.Crypto
import com.example.androidinterviewtask.data.retrofit.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoRepository {
    fun fetchCrypto(callback: (List<Crypto>?) -> Unit) {
        val call = RetrofitClient.instance.getAllCrypto()
        call.enqueue(object : Callback<List<Crypto>> {
            override fun onResponse(call: Call<List<Crypto>>, response: Response<List<Crypto>>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<List<Crypto>>, t: Throwable) {
                callback(null)
            }
        })
    }
}