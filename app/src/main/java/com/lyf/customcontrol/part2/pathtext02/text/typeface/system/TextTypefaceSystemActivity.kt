package com.lyf.customcontrol.part2.pathtext02.text.typeface.system

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_text_typeface_system.*

class TextTypefaceSystemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_typeface_system)

        root.addView(MyTextTypefaceSystemView(this))
    }
}
