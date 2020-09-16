package com.lyf.customcontrol.part1.propertyvaluesholderkeyframe08.ofobject

import android.animation.TypeEvaluator

class CharEvaluator : TypeEvaluator<Char?> {
    override fun evaluate(fraction: Float, startValue: Char?, endValue: Char?): Char? {
        return (startValue!!.toInt() + (endValue!!.toInt() - startValue.toInt()) * fraction).toChar()
    }
}