package com.lyf.customcontrol.pathtext02.rect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_rect_path.*

class RectPathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rect_path)

        root.addView(MyRectPathView(this))

    }
}
