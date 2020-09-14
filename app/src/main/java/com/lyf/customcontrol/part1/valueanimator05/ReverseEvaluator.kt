package com.lyf.customcontrol.part1.valueanimator05

import android.animation.TypeEvaluator

class ReverseEvaluator : TypeEvaluator<Int> {
    override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
        return (endValue - (endValue - startValue) * fraction).toInt()
    }
}