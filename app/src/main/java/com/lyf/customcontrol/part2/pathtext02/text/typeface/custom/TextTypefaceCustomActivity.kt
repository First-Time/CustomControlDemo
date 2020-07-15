package com.lyf.customcontrol.part2.pathtext02.text.typeface.custom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_text_typeface_custom.*

class TextTypefaceCustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_typeface_custom)

        root.addView(MyTextTypefaceCustomView(this))
    }
}
