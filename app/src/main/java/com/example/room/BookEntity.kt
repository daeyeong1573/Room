package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book") //클래스 이름은 BookEntity지만 tablename 설정으로 book으로 호출 가능
class BookEntity(
        @PrimaryKey val idx: Int, //5개의 속성중 기본키를 설정
        @ColumnInfo(name = "name") val name: String, //@ColumnInfo 어노테이션은 각 속성의 이름을 변수의 이름과 상관없이 임의로 지정할 수 있도록 도와주는 것입니다
        val author: String,
        val kind: String,
        val price: Int,

        )