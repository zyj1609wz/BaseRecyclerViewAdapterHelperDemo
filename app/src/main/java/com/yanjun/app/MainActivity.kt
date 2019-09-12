package com.yanjun.app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.bt1).setOnClickListener {
            startActivity(Intent(this, Activity1::class.java))
        }

        findViewById<TextView>(R.id.bt2).setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }

        findViewById<TextView>(R.id.bt3).setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }

        findViewById<TextView>(R.id.bt4).setOnClickListener {
            startActivity(Intent(this, Activity4::class.java))
        }
    }
}
