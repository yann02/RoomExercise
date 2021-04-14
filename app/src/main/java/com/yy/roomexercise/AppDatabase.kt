package com.yy.roomexercise

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Copyright (C), 2015-2021, 海南双猴科技有限公司
 * @Description: 暂无
 * @Author: Yingyan Wu
 * @CreateDate: 2021/4/8 18:17
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
@Database(entities = [Fruit::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fruitDao(): FruitDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (null == INSTANCE) {
                synchronized(AppDatabase::class.java) {
                    if (null == INSTANCE) {
                        INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "yy_fruit").addMigrations(MIGRATION_1_2).build()
                    }
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE fruit ADD COLUMN prince FLOAT")
            }
        }
    }
}