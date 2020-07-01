package com.lyf.customcontrol

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.line.CircleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_go_line_activity.setOnClickListener {
            startActivity(Intent(this@MainActivity, CircleActivity::class.java))
        }
    }
}
