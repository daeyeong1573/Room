package com.example.room

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("bookList", "도서 데이터를 추가합니다.")
        val addBook = AddBook(applicationContext)
        addBook.start()

        Thread.sleep(1000)

        Log.e("bookList", "도서 데이터를 수정합니다.")
        val updateBook = UpdateBook(applicationContext)
        updateBook.start()

        Thread.sleep(1000)


        Log.e("bookList", "도서 데이터를 삭제합니다.")
        val deleteBook = DeleteBook(applicationContext)
        deleteBook.start()

        Thread.sleep(1000)

        Log.e("bookList", "도서 데이터를 조회합니다.")
        val getBook = GetBook(applicationContext)
        getBook.start()
    }
}

class AddBook(val context: Context) : Thread() {
    override fun run() {
        val book = BookEntity(1, "공간이 만든 공간", "유현준", "교양 인문학", 16500)
        BookDatabase
                .getInstance(context)!!
                .getBookDao()
                .insert(book)

        val book2 = BookEntity(2, "TED TALKS 테드 토크", "크리스 앤더슨", "자기계발", 16000)
        BookDatabase
                .getInstance(context)!!
                .getBookDao()
                .insert(book2)

        val book3 = BookEntity(3, "철학은 어떻게 삶의 무기가 되는가", "야마구치 슈", "철학", 16000)
        BookDatabase
                .getInstance(context)!!
                .getBookDao()
                .insert(book3)
    }
}

class UpdateBook(val context: Context) : Thread() {
    override fun run() {
        BookDatabase
                .getInstance(context)!!
                .getBookDao()
                .update(1, "2020 정보처리기능사 실기 기본서", "길벗알앤디", "컴퓨터 IT", 19000)
    }
}

class GetBook(val context: Context) : Thread() {
    override fun run() {
        val items = BookDatabase
                .getInstance(context)!!
                .getBookDao()
                .getAllBook()

        for (i in items) {
            Log.d("bookList", "${i.idx} | ${i.name} ${i.author} | ${i.kind} | ${i.price}")
        }
    }
}

class DeleteBook(val context: Context) : Thread() {
    override fun run() {
        BookDatabase
                .getInstance(context)!!
                .getBookDao()
                .delete(3)
    }
}