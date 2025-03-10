package com.example.androidinterviewtask.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidinterviewtask.data.model.Crypto
import com.example.androidinterviewtask.data.repositories.CryptoRepository


class CryptoViewModel: ViewModel() {
    private val repository = CryptoRepository()

    private val _tickers = MutableLiveData<List<Crypto>?>()
    val tickers: LiveData<List<Crypto>?> get() = _tickers

    fun loadTickers() {
        repository.fetchCrypto { result ->
            _tickers.postValue(result)
        }
    }
}