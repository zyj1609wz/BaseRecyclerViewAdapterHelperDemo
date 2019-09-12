package com.yanjun.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.yanjun.app.demo2.Adapter2
import com.yanjun.app.demo2.MultiItem

/*
 * @Created by zhaoyanjun
 * @time 2019-09-12 18:00
 * 多类型 item
 */
class Activity2 : AppCompatActivity() {

    lateinit var mAdapter: Adapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        val recycler: RecyclerView = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        mAdapter = Adapter2(getList())
        recycler.adapter = mAdapter

        recycler.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(
                adapter: BaseQuickAdapter<*, *>?,
                view: View?,
                position: Int
            ) {
                Toast.makeText(this@Activity2, "item $position ", Toast.LENGTH_SHORT).show()
            }

        })

        recycler.addOnItemTouchListener(object : OnItemChildClickListener() {
            override fun onSimpleItemChildClick(
                adapter: BaseQuickAdapter<*, *>?,
                view: View,
                position: Int
            ) {
                when (view.id) {
                    R.id.button -> {
                        Toast.makeText(this@Activity2, "button $position ", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }


        })
    }

    fun getList(): MutableList<MultiItem> {
        var list = mutableListOf<MultiItem>()
        for (i in 0..100) {
            var user = User("第 $i 数据", i, Constant.image)

            var item = MultiItem(MultiItem.TYPE_TEX, user)
            var item2 = MultiItem(MultiItem.TYPE_IMAGE, user)
            list.add(item)
            list.add(item2)

        }
        return list
    }
}
