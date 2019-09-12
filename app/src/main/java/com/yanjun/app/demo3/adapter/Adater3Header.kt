package com.yanjun.app.demo3.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yanjun.app.R

class Adater3Header(list: MutableList<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity3_item, list) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.tv, item)
    }

}