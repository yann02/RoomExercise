package com.yy.roomexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = Room.databaseBuilder(this, AppDatabase::class.java, "yy_fruit").addMigrations(MIGRATION_1_2).build()
        val apple = Fruit("strawberry")
        apple.prince = 15f
        runBlocking {
            withContext(Dispatchers.IO) {
                db.fruitDao().insert(apple)
            }
        }
    }

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE fruit ADD COLUMN prince FLOAT")
        }
    }
}