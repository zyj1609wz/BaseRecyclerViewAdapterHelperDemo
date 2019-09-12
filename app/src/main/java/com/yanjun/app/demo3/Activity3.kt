package com.yanjun.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.yanjun.app.demo3.adapter.Adater3Header
import com.yanjun.app.demo3.adapter.Adater3Main

class Activity3 : AppCompatActivity() {

    var headerAdapter: Adater3Header? = null
    var headRecyclerView: RecyclerView? = null
    var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)

        val recycler: RecyclerView = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        var adater3 = Adater3Main(null)
        adater3.addHeaderView(getHeaderView())
        recycler.adapter = adater3
        adater3.setOnLoadMoreListener({

            recycler.postDelayed({
                Log.e("zhaoyanjun:", "more---")

                //更新数据
                adater3.addData(getMainRefresh())

                //刷新界面 加载更多完成
                adater3.loadMoreEnd()

            }, 3000)

        }, recycler)

        headerAdapter?.setOnLoadMoreListener({

            Log.e("zhaoyanjun:", "load more");


//            headRecyclerView?.postDelayed({
//                Log.e("zhaoyanjun:", "header more---")
//                page++
//
//                //更新数据
//                headerAdapter?.addData(getRereshData())
//
//                //刷新界面  加载更多完成
//                headerAdapter?.loadMoreComplete()
//
//                if (page == 3) {
//                    headerAdapter?.setEnableLoadMore(false)
//                    adater3?.setNewData(getMain())
//                }
//            }, 3000)

        }, headRecyclerView)
    }

    fun getHeaderView(): View {
        val header = LayoutInflater.from(this).inflate(R.layout.activity3_header, null)
        headRecyclerView = header.findViewById<RecyclerView>(R.id.recyclerview)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        headRecyclerView?.setHasFixedSize(false)
        headRecyclerView?.layoutManager = linearLayoutManager
        headerAdapter = Adater3Header(getData())
        headRecyclerView?.adapter = headerAdapter

        return header
    }

    private fun getMain(): MutableList<String> {
        val list = mutableListOf<String>()
        for (i in 0..15) {
            list.add("main $i")
        }
        return list
    }

    private fun getMainRefresh(): MutableList<String> {
        val list = mutableListOf<String>()
        for (i in 0..15) {
            list.add("main refresh $i")
        }
        return list
    }

    private fun getData(): MutableList<String> {
        val list = mutableListOf<String>()
        for (i in 0..15) {
            list.add("header $i")
        }
        return list
    }

    private fun getRereshData(): MutableList<String> {
        val list = mutableListOf<String>()
        for (i in 0..15) {
            list.add("update $i")
        }
        return list
    }


}
