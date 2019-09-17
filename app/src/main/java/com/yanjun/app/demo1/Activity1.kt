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
import com.chad.library.adapter.base.listener.SimpleClickListener
import com.yanjun.app.demo1.Adapter1
/*
 * @Created by zhaoyanjun
 * @time 2019-09-12 18:02
 * 单类型 item
 */
class Activity1 : AppCompatActivity() {

    lateinit var mAdapter: Adapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1)
        val recycler: RecyclerView = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        mAdapter = Adapter1(getList())
        recycler.adapter = mAdapter

        recycler.addOnItemTouchListener(object : SimpleClickListener() {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                Toast.makeText(
                    this@Activity1,
                    "click $position",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemLongClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                Toast.makeText(
                    this@Activity1,
                    "long click $position",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemChildClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                Toast.makeText(
                    this@Activity1,
                    "button click $position",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemChildLongClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                Toast.makeText(this@Activity1, "button long click $position", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    fun getList(): MutableList<User> {
        var list = mutableListOf<User>()
        for (i in 0..100) {
            var user = User("第 $i 数据", i, Constant.image)
            list.add(user)
        }
        return list
    }
}
