package com.lyf.customcontrol.part1.propertyvaluesholderkeyframe08.offloatofint

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_property_values_holder.*

class PropertyValuesHolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_values_holder)

        val rotationPropertyValuesHolder =
            PropertyValuesHolder.ofFloat("rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f)
        val backgroundColorPropertyValuesHolder = PropertyValuesHolder.ofInt(
            "backgroundColor",
            0xffffffff.toInt(),
            0xffff00ff.toInt(),
            0xffffff00.toInt(),
            0xffffffff.toInt()
        )
        val propertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(textView, rotationPropertyValuesHolder, backgroundColorPropertyValuesHolder)
        propertyValuesHolder.duration = 3000
        btn_start_anim.setOnClickListener { propertyValuesHolder.start() }
        btn_cancel_anim.setOnClickListener { propertyValuesHolder.cancel() }
    }
}