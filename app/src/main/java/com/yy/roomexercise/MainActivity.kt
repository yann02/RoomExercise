package com.yy.roomexercise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.shkj.cm.SMMainActivity
import com.shkj.lib1.LibMainActivity
//import com.shkj.cm.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    private lateinit var tvContent: TextView
    private lateinit var etName: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSearch: Button
    private var fruitsLiveData = RoomHelper.fruitDao?.queryAllEntitiesOnLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("wyy", "activity onCreate ${System.currentTimeMillis()}")
        Log.d("wyy", "activity onCreate ${date2TimeStamp("2021-04-19 09:00", "yyyy-MM-dd HH:mm")}")
        Log.d("wyy", "activity onCreate ${date2TimeStamp("2021-04-17 00:00:00", "yyyy-MM-dd HH:mm:ss")}")
        Log.d("wyy", "activity onCreate ${date2TimeStamp("2021-04-01 00:00:00", "yyyy-MM-dd HH:mm:ss")}")
        setContentView(R.layout.activity_main)
        tvContent = findViewById(R.id.tv_content)
        etName = findViewById(R.id.et_name)
        btnAdd = findViewById(R.id.btn_add)
        btnSearch = findViewById(R.id.btn_search)
        btnAdd.setOnClickListener {
//            val name = etName.text.toString()
//            etName.setText("")
//            val fruit = Fruit(name)
//            runBlocking {
//                withContext(Dispatchers.IO) {
//                    RoomHelper.fruitDao?.insert(fruit)
//                }
//            }
            startActivity(Intent(this@MainActivity, LibMainActivity::class.java))
        }
        btnSearch.setOnClickListener {
            runBlocking {
//                val a = RoomHelper.fruitDao?.queryAllEntitiesOnCoroutine()
//                Log.d("wyy", "a is $a")
                startActivity(Intent(this@MainActivity, SMMainActivity::class.java))
            }
        }
        fruitsLiveData?.observe(this, Observer {
            Log.d("wyy", "fruit's size is ${it.size}")
            tvContent.text = it.toString()
        })

    }

    /**
     * 日期格式字符串转换成时间戳
     * @param date 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    fun date2TimeStamp(date_str: String?, format: String?): String? {
        try {
            val sdf = SimpleDateFormat(format)
            return java.lang.String.valueOf(sdf.parse(date_str).getTime())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

}