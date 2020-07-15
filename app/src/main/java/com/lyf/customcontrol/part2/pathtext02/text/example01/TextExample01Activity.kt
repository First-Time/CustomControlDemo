package com.lyf.customcontrol.part2.pathtext02.text.example01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_text_example01.*

class TextExample01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_example01)

        root.addView(MyTextView01(this))
    }
}
