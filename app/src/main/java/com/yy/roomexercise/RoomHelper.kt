package com.yy.roomexercise

/**
 * Copyright (C), 2015-2021, 海南双猴科技有限公司
 * @Description: 暂无
 * @Author: Yingyan Wu
 * @CreateDate: 2021/4/14 15:20
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
object RoomHelper {
    private val appDatabase by lazy {
        AppDatabase.getInstance(MyApplication.instance)
    }
    val fruitDao by lazy {
        appDatabase?.fruitDao()
    }
}