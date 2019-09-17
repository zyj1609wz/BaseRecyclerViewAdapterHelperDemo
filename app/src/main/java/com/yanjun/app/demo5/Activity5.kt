package com.yanjun.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.yanjun.app.demo5.Adapter5
import com.chad.library.adapter.base.listener.SimpleClickListener


class Activity5 : AppCompatActivity(), View.OnClickListener {


    lateinit var bt1: Button
    lateinit var bt2: Button
    lateinit var bt3: Button
    lateinit var bt4: Button
    lateinit var bt5: Button

    lateinit var mAdapter: Adapter5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity5)

        bt1 = findViewById(R.id.bt1)
        bt2 = findViewById(R.id.bt2)
        bt3 = findViewById(R.id.bt3)
        bt4 = findViewById(R.id.bt4)
        bt5 = findViewById(R.id.bt5)

        bt1.setOnClickListener(this)
        bt2.setOnClickListener(this)
        bt3.setOnClickListener(this)
        bt4.setOnClickListener(this)
        bt5.setOnClickListener(this)

        val recycler: RecyclerView = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        mAdapter = Adapter5(getList())
        recycler.adapter = mAdapter

        recycler.addOnItemTouchListener(object : SimpleClickListener() {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                Toast.makeText(
                    this@Activity5,
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
                    this@Activity5,
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
                    this@Activity5,
                    "button click $position",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemChildLongClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                Toast.makeText(this@Activity5, "button long click $position", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onClick(v: View) {
        resetBt()
        v.setBackgroundColor(resources.getColor(R.color.colorAccent))

        when (v.id) {
            R.id.bt1 -> {
                mAdapter.openLoadAnimation()
            }

            R.id.bt2 -> {
                mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
            }

            R.id.bt3 -> {
                mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM)
            }

            R.id.bt4 -> {
                mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT)
            }

            R.id.bt5 -> {
                mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT)
            }
        }
    }

    fun resetBt() {
        bt1.setBackgroundColor(resources.getColor(R.color.white))
        bt2.setBackgroundColor(resources.getColor(R.color.white))
        bt3.setBackgroundColor(resources.getColor(R.color.white))
        bt4.setBackgroundColor(resources.getColor(R.color.white))
        bt5.setBackgroundColor(resources.getColor(R.color.white))
    }


    fun getList(): MutableList<User> {
        var list = mutableListOf<User>()
        for (i in 0..65) {
            var user = User("第 $i 数据", i, Constant.image)
            list.add(user)
        }
        return list
    }

}
