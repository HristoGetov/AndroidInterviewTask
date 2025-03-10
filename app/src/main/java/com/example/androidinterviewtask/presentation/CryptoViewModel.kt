package com.example.androidinterviewtask.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidinterviewtask.data.model.Crypto
import com.example.androidinterviewtask.data.repositories.CryptoRepository
import kotlinx.coroutines.launch


class CryptoViewModel(application: Application) : AndroidViewModel(application){
    private val repository = CryptoRepository(application)

    private val _cryptos = MutableLiveData<List<Crypto>?>()
    val cryptos: LiveData<List<Crypto>?> get() = _cryptos

    fun loadCryptos() {
       viewModelScope.launch {
           _cryptos.postValue(repository.getCryptoFromDatabase())

           val apiData = repository.fetchCryptoFromApi()
           Log.e("Log",apiData.toString())
           if (apiData != null){
               _cryptos.postValue(apiData)
           }else{
               _cryptos.postValue(repository.getCryptoFromDatabase())
           }
       }
    }
    fun reloadCryptoFromApi() {
        viewModelScope.launch {
            val apiData = repository.fetchCryptoFromApi()
            if (apiData != null) _cryptos.postValue(apiData)
        }
    }
}