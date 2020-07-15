package com.lyf.customcontrol.part2.pathtext02.path.arc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_arc_path.*

class ArcPathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arc_path)

        root.addView(MyArcPathView(this))
    }
}
