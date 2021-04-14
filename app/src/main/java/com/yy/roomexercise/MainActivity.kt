package com.yy.roomexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var tvContent: TextView
    private lateinit var etName: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSearch: Button
    private var fruitsLiveData = RoomHelper.fruitDao?.queryAllEntitiesOnLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("wyy", "activity onCreate")
        setContentView(R.layout.activity_main)
        tvContent = findViewById(R.id.tv_content)
        etName = findViewById(R.id.et_name)
        btnAdd = findViewById(R.id.btn_add)
        btnSearch = findViewById(R.id.btn_search)
        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            etName.setText("")
            val fruit = Fruit(name)
            runBlocking {
                withContext(Dispatchers.IO) {
                    RoomHelper.fruitDao?.insert(fruit)
                }
            }
        }
        btnSearch.setOnClickListener {
            runBlocking {
                val a = RoomHelper.fruitDao?.queryAllEntitiesOnCoroutine()
                Log.d("wyy", "a is $a")
            }
        }
        fruitsLiveData?.observe(this, Observer {
            Log.d("wyy", "fruit's size is ${it.size}")
            tvContent.text = it.toString()
        })
    }


}