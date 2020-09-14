package com.lyf.customcontrol.part1.valueanimator06.customobject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_point_object.*

class PointObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point_object)
        btn_start_anim.setOnClickListener { myPointView.doPointAnim() }
        btn_cancel_anim.setOnClickListener { myPointView.cancelPointAnim() }
    }
}