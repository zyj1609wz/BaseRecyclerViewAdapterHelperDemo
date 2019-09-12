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
import com.yanjun.app.demo3.Adapter4

class Activity4 : AppCompatActivity() {

    lateinit var mAdapter: Adapter4
    var loadTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity4)
        val recycler: RecyclerView = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        mAdapter = Adapter4(getList())
        recycler.adapter = mAdapter

        recycler.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(
                adapter: BaseQuickAdapter<*, *>?,
                view: View?,
                position: Int
            ) {
                Toast.makeText(this@Activity4, "item $position ", Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(this@Activity4, "button $position ", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }


        })

        //加载更多
        mAdapter.setOnLoadMoreListener({
            loadMore()
        }, recycler)
    }

    fun getList(): MutableList<User> {
        var list = mutableListOf<User>()
        for (i in 0..15) {
            var user = User("第 $i 数据", i, Constant.image)
            list.add(user)
        }
        return list
    }

    /**
     * 模拟网络请求加载更多
     */
    fun loadMore() {
        Thread {
            Thread.sleep(3000)
            runOnUiThread {

                if (loadTime == 1) {
                    //加载失败的情况
                    mAdapter.loadMoreFail()
                } else {
                    //加载成功的情况
                    mAdapter.addData(getGetNextPageData())

                    if (loadTime == 2) {
                        //全部数据加载完成，最后一页，不会再出发上拉UI
                        mAdapter.loadMoreEnd()
                    } else {
                        //加载一页成功，还会出发上拉UI
                        mAdapter.loadMoreComplete()
                    }
                }
                loadTime++
            }
        }.start()
    }

    /**
     * 获取下一页数据
     */
    fun getGetNextPageData(): MutableList<User> {
        var list = mutableListOf<User>()
        for (i in 0..15) {
            var user = User("更新 第 $i 数据", i, Constant.image)
            list.add(user)
        }
        return list
    }
}
