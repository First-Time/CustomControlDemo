package com.lyf.customcontrol.part2.pathtext02.text.example02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_text_example02.*

class TextExample02Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_example02)

        root.addView(MyTextView02(this))
    }
}
