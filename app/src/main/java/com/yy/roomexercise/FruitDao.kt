package com.yy.roomexercise

import androidx.room.*

/**
 * Copyright (C), 2015-2021, 海南双猴科技有限公司
 * @Description: 暂无
 * @Author: Yingyan Wu
 * @CreateDate: 2021/4/8 17:50
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
@Dao
interface FruitDao {
    @Insert
    fun insert(entity: Fruit)

    @Delete
    fun delete(entity: Fruit): Int

    @Update
    fun update(entity: Fruit): Int

    @Query("SELECT * FROM fruit")
    fun queryEntitiesOfAll(): List<Fruit>
}