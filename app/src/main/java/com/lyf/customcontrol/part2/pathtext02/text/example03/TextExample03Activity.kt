package com.lyf.customcontrol.part2.pathtext02.text.example03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_text_example03.*

class TextExample03Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_example03)

        root.addView(MyTextView03(this))
    }
}
