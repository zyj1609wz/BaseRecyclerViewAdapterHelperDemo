package com.yanjun.app.demo3

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yanjun.app.R
import com.yanjun.app.User

class Adapter4(list: MutableList<User>) :
    BaseQuickAdapter<User, BaseViewHolder>(R.layout.activity4_item, list) {

    override fun convert(helper: BaseViewHolder, item: User) {
        helper.setText(R.id.tv, item.name)
        helper.addOnClickListener(R.id.button)
        Glide.with(helper.itemView.context).load(item.image).into(helper.getView(R.id.image))
    }
}