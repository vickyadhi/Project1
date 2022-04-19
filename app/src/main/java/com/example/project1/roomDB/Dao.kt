package com.example.project1.roomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.project1.modelclass.Quote

@Dao
interface Dao {


@Insert(onConflict = OnConflictStrategy.IGNORE)
    fun userList (quote: Quote)

    @Query("SELECT * FROM user's ORDER BY id ASC")
    fun allData() : LiveData<List<Quote>>

}