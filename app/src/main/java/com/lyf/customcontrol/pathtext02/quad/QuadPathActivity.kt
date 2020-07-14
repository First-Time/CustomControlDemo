package com.lyf.customcontrol.pathtext02.quad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_quad_path.*

class QuadPathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quad_path)

        root.addView(MyQuadPathView(this))
    }
}
