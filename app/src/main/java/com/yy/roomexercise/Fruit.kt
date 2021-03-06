package com.yy.roomexercise

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Copyright (C), 2015-2021, 海南双猴科技有限公司
 * @Description: 暂无
 * @Author: Yingyan Wu
 * @CreateDate: 2021/4/8 15:49
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
@Entity
data class Fruit(
    var name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var prince: Float? = 0f
    override fun toString(): String {
        return "Prince of $name is $prince"
    }
}