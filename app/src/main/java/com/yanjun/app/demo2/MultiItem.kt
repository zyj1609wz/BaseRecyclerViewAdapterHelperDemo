package com.yanjun.app.demo2

import com.chad.library.adapter.base.entity.MultiItemEntity

class MultiItem(var type: Int, var data: Any) : MultiItemEntity {

    companion object {
        const val TYPE_TEX = 1
        const val TYPE_IMAGE = 2
    }

    override fun getItemType(): Int {
        return type
    }

}