package com.lyf.customcontrol.part3.waterfalllayout03

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

class MyWaterFallLayoutParams : ViewGroup.LayoutParams {
    var left = 0
    var top = 0
    var right = 0
    var bottom = 0

    constructor(c: Context, attrs: AttributeSet?) : super(c, attrs)
    constructor(width: Int, height: Int) : super(width, height)
    constructor(source: ViewGroup.LayoutParams?) : super(source)
}