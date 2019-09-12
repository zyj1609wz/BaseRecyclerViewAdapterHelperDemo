package com.yanjun.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.yanjun.app.demo3.Adapter3

class Activity3 : AppCompatActivity() {

    lateinit var mAdapter: Adapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)
        val recycler: RecyclerView = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        mAdapter = Adapter3(getList())
        recycler.adapter = mAdapter

        recycler.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(
                adapter: BaseQuickAdapter<*, *>?,
                view: View?,
                position: Int
            ) {
                Toast.makeText(this@Activity3, "item $position ", Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(this@Activity3, "button $position ", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }


        })

        var head = LayoutInflater.from(this).inflate(R.layout.activity3_header,null,false)
        var foot = LayoutInflater.from(this).inflate(R.layout.activity3_footer,null,false)
        mAdapter.addHeaderView(head)
        mAdapter.addFooterView(foot)
    }

    fun getList(): MutableList<User> {
        var list = mutableListOf<User>()
        for (i in 0..15) {
            var user = User("第 $i 数据", i, Constant.image)
            list.add(user)
        }
        return list
    }
}
