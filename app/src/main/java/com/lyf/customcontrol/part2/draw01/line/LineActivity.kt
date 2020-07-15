package com.lyf.customcontrol.part2.draw01.line

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_line.*

class LineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line)

        val displayMetrics = resources.displayMetrics
        root.addView(MyLineView(this), displayMetrics.widthPixels, displayMetrics.heightPixels / 2)
    }
}
