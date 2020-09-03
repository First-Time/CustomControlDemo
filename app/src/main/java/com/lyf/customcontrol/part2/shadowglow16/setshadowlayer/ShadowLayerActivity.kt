package com.lyf.customcontrol.part2.shadowglow16.setshadowlayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_shadow_layer.*

class ShadowLayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shadow_layer)

        btn_radius.setOnClickListener { myShadowLayerView.changeRadius() }
        btn_dx.setOnClickListener { myShadowLayerView.changeDx() }
        btn_dy.setOnClickListener { myShadowLayerView.changeDy() }
        btn_hide.setOnClickListener { myShadowLayerView.clearShadow() }
        btn_show.setOnClickListener { myShadowLayerView.showShadow() }
    }
}