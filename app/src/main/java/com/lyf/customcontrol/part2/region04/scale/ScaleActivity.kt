package com.lyf.customcontrol.part2.region04.scale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_scale.*

class ScaleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scale)

        root.addView(MyScaleView(this))
    }
}
