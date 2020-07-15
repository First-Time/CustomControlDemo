package com.lyf.customcontrol.part2.region04.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_translate.*

class TranslateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)

        root.addView(MyTranslateView(this))
    }
}
