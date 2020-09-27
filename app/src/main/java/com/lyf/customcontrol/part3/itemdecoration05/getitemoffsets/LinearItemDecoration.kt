package com.lyf.customcontrol.part3.itemdecoration05.getitemoffsets

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lyf.customcontrol.R

class LinearItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val mPaint = Paint()
    private val mBitmap: Bitmap

    init {
        mPaint.color = Color.GREEN

        //使用Bitmap
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        mBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_launcher)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = 1
    }
}