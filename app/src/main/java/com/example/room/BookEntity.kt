package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
class BookEntity(@PrimaryKey val idx : Int,
                 @ColumnInfo(name = "name") val name: String,
                 val author : String,
                 val price : Int,
                 val kind : String
)