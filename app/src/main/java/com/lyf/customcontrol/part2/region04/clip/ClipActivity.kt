package com.lyf.customcontrol.part2.region04.clip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_clip.*

class ClipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clip)

        root.addView(MyClipView(this))
    }
}
