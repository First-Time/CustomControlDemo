package com.lyf.customcontrol.part2.pathquadto06.gesture.lineto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_gesture_line_to.*

class GestureLineToActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesture_line_to)

        btn_reset.setOnClickListener {
            myGestureView.reset()
        }
    }
}