package com.yy.roomexercise

import androidx.room.Database
import androidx.room.RoomDatabase

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
}