package com.lyf.customcontrol.part1.propertyvaluesholderkeyframe08.ofobject

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class MyTextView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    AppCompatTextView(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    fun setCharText(char: Char?) {
        text = char.toString()
    }
}