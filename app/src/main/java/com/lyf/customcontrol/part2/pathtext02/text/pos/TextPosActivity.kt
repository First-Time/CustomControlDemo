package com.lyf.customcontrol.part2.pathtext02.text.pos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_text_pos.*

class TextPosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_pos)

        root.addView(MyTextPosView(this))
    }
}
