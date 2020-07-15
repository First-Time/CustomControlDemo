package com.lyf.customcontrol.part2.region04.rotate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_rotate.*

class RotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate)

        root.addView(MyRotateView(this))
    }
}
