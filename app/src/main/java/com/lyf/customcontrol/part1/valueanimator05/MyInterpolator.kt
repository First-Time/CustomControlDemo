package com.lyf.customcontrol.part1.valueanimator05

import android.animation.TimeInterpolator

class MyInterpolator : TimeInterpolator {
    override fun getInterpolation(input: Float): Float {
        return 1 - input
    }
}