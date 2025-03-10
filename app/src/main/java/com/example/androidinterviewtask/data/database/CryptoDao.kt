package com.example.androidinterviewtask.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidinterviewtask.data.model.Crypto

@Dao
interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrypto(crypto: List<Crypto>)

    @Query("SELECT * FROM crypto_table ORDER BY symbol ASC")
    suspend fun getAllCrypto(): List<Crypto>

    @Query("DELETE FROM crypto_table")
    suspend fun clearCrypto()
}