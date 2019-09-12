package com.yanjun.app.demo2

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yanjun.app.R
import com.yanjun.app.User

/*
 * @Created by zhaoyanjun
 * @time 2019-09-12 17:57
 * 多类型 itme
 */
class Adapter2(list: MutableList<MultiItem>) :
    BaseMultiItemQuickAdapter<MultiItem, BaseViewHolder>(list) {

    init {
        addItemType(MultiItem.TYPE_TEX, R.layout.activity2_item_tex)
        addItemType(MultiItem.TYPE_IMAGE, R.layout.activity2_item_image)
    }

    override fun convert(helper: BaseViewHolder, item: MultiItem) {
        when (helper.itemViewType) {
            MultiItem.TYPE_TEX -> {
                var data:User = item.data as User
                helper.setText(R.id.tv, data.name)
                helper.addOnClickListener(R.id.button)
            }

            MultiItem.TYPE_IMAGE -> {
                var data:User = item.data as User
                Glide.with(helper.itemView.context).load(data.image).into(helper.getView(R.id.image))
            }
        }
    }
}