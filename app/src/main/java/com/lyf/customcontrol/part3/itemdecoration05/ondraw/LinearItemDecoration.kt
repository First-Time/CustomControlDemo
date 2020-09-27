package com.lyf.customcontrol.part3.itemdecoration05.ondraw

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

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val layoutManager = parent.layoutManager
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            //画圆
            /*val cx = layoutManager?.getLeftDecorationWidth(child)?.toFloat()!! / 2
            val cy = child.top + child.height / 2f
            c.drawCircle(cx, cy, 20f, mPaint)*/

            //使用Bitmap
            c.drawBitmap(mBitmap, 0f, child.top.toFloat(), mPaint)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = 1
        outRect.left = 200
    }
}