package com.lyf.customcontrol.part1.valueanimator05

import android.animation.TypeEvaluator

class MyEvaluator : TypeEvaluator<Int> {
    override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
        return ((200 + startValue) + (endValue - startValue) * fraction).toInt()
    }
}