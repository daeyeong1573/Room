package com.example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao{

    @Query("SELECT * FROM book")
    fun getAllBook() : List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookEntity : BookEntity)

    @Query("UPDATE book set name = :name, author = :author, kind = :kind, price = :price WHERE idx = :idx")
    fun update(idx : Int, name : String, author : String, kind : String, price : Int)

    @Query("DELETE FROM book WHERE idx = :idx")
    fun delete(idx : Int)
}