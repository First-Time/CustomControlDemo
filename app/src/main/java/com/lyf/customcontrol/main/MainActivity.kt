package com.lyf.customcontrol.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import com.lyf.customcontrol.part1.Part1Activity
import com.lyf.customcontrol.part2.Part2Activity
import com.lyf.customcontrol.part3.Part3Activity
import com.lyf.customcontrol.shape.ShapeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_part1.setOnClickListener(this)
        btn_part2.setOnClickListener(this)
        btn_part3.setOnClickListener(this)
        btn_part_shape.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_part1 -> {
                startActivity(Intent(this@MainActivity, Part1Activity::class.java))
            }
            R.id.btn_part2 -> {
                startActivity(Intent(this@MainActivity, Part2Activity::class.java))
            }
            R.id.btn_part3 -> {
                startActivity(Intent(this@MainActivity, Part3Activity::class.java))
            }
            R.id.btn_part_shape -> {
                startActivity(Intent(this@MainActivity, ShapeActivity::class.java))
            }
        }
    }
}