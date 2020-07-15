package com.lyf.customcontrol.part2.pathtext02.path.line

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_line_path.*

class LinePathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_path)

        root.addView(MyLinePathView(this))
    }
}
