package com.lyf.customcontrol.part1.propertyvaluesholderkeyframe08.ofobject

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_property_values_holder_of_object.*

class PropertyValuesHolderOfObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_values_holder_of_object)

        val propertyValuesHolder =
            PropertyValuesHolder.ofObject("charText", CharEvaluator(), 'A', 'Z')
        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(textView, propertyValuesHolder)
        objectAnimator.duration = 5000
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }
    }
}