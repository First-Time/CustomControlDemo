package com.lyf.customcontrol.pathtext02.roundrect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_round_rect_path.*

class RoundRectPathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round_rect_path)

        root.addView(MyRoundPathView(this))
    }
}
