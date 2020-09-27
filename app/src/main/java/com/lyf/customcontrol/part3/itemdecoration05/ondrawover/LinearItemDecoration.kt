package com.lyf.customcontrol.part3.itemdecoration05.ondrawover

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lyf.customcontrol.R

class LinearItemDecoration(var context: Context) : RecyclerView.ItemDecoration() {
    private val mPaint = Paint()
    private val mBitmap: Bitmap

    init {
        mPaint.color = Color.GREEN

        //使用Bitmap
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        mBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.img_medal)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        //画渐变蒙版
        val gradient = LinearGradient(
            0f,
            0f,
            0f,
            parent.getChildAt(0).height * 3f,
            context.resources.getColor(R.color.colorPrimary),
            context.resources.getColor(R.color.colorTranslationPrimary),
            Shader.TileMode.CLAMP
        )
        mPaint.shader = gradient
        c.drawRect(0f, 0f, parent.width.toFloat(), parent.getChildAt(0).height * 3f, mPaint)

        //画勋章
        val layoutManager = parent.layoutManager
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val index = parent.getChildLayoutPosition(child)
            val left = layoutManager?.getLeftDecorationWidth(child)
            if (index % 5 == 0)
                c.drawBitmap(
                    mBitmap,
                    left?.minus(mBitmap.width / 2f)!!,
                    child.top.toFloat(),
                    mPaint
                )
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