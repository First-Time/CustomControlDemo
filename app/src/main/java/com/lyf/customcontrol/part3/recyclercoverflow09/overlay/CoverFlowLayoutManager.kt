package com.lyf.customcontrol.part3.recyclercoverflow09.overlay

import android.graphics.Rect
import android.util.SparseArray
import android.util.SparseBooleanArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.max

class CoverFlowLayoutManager : RecyclerView.LayoutManager() {
    private var mSumDx = 0
    private var mTotalWidth = 0
    private var mItemWidth = 0
    private var mItemHeight = 0
    private var mIntervalWidth: Int = 0
    private var mStartX: Int = 0
    private val mItemRectArray = SparseArray<Rect>()
    private val mHasAttachedItems = SparseBooleanArray() //true表示已经在布局中，false表示没有在布局中

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        detachAndScrapAttachedViews(recycler!!)
        if (itemCount == 0) {
            return
        }

        mItemRectArray.clear()
        mHasAttachedItems.clear()

        //将item的位置存储起来
        val childView = recycler?.getViewForPosition(0)
        measureChildWithMargins(childView, 0, 0)
        mItemWidth = getDecoratedMeasuredWidth(childView)
        mItemHeight = getDecoratedMeasuredHeight(childView)
        mIntervalWidth = mItemWidth / 2
        mStartX = width / 2 - mIntervalWidth
        val visibleCount = ceil(getHorizontalSpace() / mIntervalWidth.toFloat()).toInt()

        var offsetX = paddingStart //offsetX首先偏移paddingStart的距离

        for (i in 0 until itemCount) {
            //需要考虑paddingLeft
            val rect = Rect(
                mStartX + offsetX,
                paddingTop,
                mStartX + offsetX + mItemWidth,
                mItemHeight + paddingTop
            )
            mItemRectArray.put(i, rect)
            mHasAttachedItems.put(i, false)
            offsetX += mIntervalWidth
        }

        for (i in 0 until visibleCount) {
            val rect = mItemRectArray.get(i)
            val view = recycler?.getViewForPosition(i)
            addView(view)
            //addView后一定要measure，先measure再layout
            measureChildWithMargins(view!!, 0, 0)
            layoutDecorated(view, rect.left, rect.top, rect.right, rect.bottom)
        }
        //如果所有子View的高度和没有填满RecyclerView的高度，
        //则将高度设置为RecyclerView的高度
        mTotalWidth = max(offsetX, getHorizontalSpace())
    }

    override fun canScrollHorizontally(): Boolean {
        return true
    }

    private fun getHorizontalSpace(): Int {
        return width - paddingStart - paddingEnd
    }

    /**
     * 获取当前屏幕的位置
     */
    private fun getVisibleArea(): Rect {
        return Rect(
            paddingStart + mSumDx,
            paddingTop,
            mSumDx + width - paddingEnd,
            height - paddingBottom
        )
    }

    override fun scrollHorizontallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        if (childCount <= 0) return dy

        var travel = dy
        //如果滑动到最顶部
        /*if (mSumDx + dy < 0) {
            travel = -mSumDx
        } else if (mSumDx + travel > getMaxOffset()) {
            //如果滑动到最底部
            travel = getMaxOffset() - mSumDx
        }*/

        if (travel == 0) return 0

        mSumDx += travel

        val visibleRect = getVisibleArea()
        //左右滑动时回收越界子View
        for (i in childCount - 1 downTo 0) {
            val child = getChildAt(i)
            val position = getPosition(child!!)
            val rect = mItemRectArray.get(position)
            if (Rect.intersects(visibleRect, rect)) {
                layoutDecoratedWithMargins(
                    child,
                    rect.left - mSumDx,
                    rect.top,
                    rect.right - mSumDx,
                    rect.bottom
                )
                handleChildView(child, rect.left - mStartX - mSumDx)
                mHasAttachedItems.put(position, true)
            } else {
                removeAndRecycleView(child, recycler!!)
                mHasAttachedItems.put(position, false)
            }
        }

        val lastView = getChildAt(childCount - 1)
        val firstView = getChildAt(0)

        //布局子View阶段
        if (travel > 0) {
            val minPos = getPosition(firstView!!)

            //顺序addChildView
            for (i in minPos until itemCount) {
                val rect = mItemRectArray.get(i)
                if (Rect.intersects(visibleRect, rect) && !mHasAttachedItems.get(i)) {
                    val child = recycler?.getViewForPosition(i)
                    addView(child)
                    measureChildWithMargins(child!!, 0, 0)
                    layoutDecorated(
                        child!!,
                        rect.left - mSumDx,
                        rect.top,
                        rect.right - mSumDx,
                        rect.bottom
                    )
                    handleChildView(child, rect.left - mStartX - mSumDx)
                    mHasAttachedItems.put(i, true)
                }
            }
        } else if (travel < 0) {
            val maxPos = getPosition(lastView!!)

            //顺序addChildView
            for (i in maxPos downTo 0) {
                val rect = mItemRectArray.get(i)
                if (Rect.intersects(visibleRect, rect) && !mHasAttachedItems.get(i)) {
                    val child = recycler?.getViewForPosition(i)
                    addView(child, 0)
                    measureChildWithMargins(child!!, 0, 0)
                    layoutDecorated(
                        child!!,
                        rect.left - mSumDx,
                        rect.top,
                        rect.right - mSumDx,
                        rect.bottom
                    )
                    handleChildView(child, rect.left - mStartX - mSumDx)
                    mHasAttachedItems.put(i, true)
                }
            }
        }
        return travel
    }

    fun getFirstVisiblePosition(): Int {
        if (childCount <= 0) return 0
        val view = getChildAt(0)
        return getPosition(view!!)
    }

    fun getCenterPosition(): Int {
        var pos = mSumDx / mIntervalWidth
        val more = mSumDx % mIntervalWidth
        if (more > mIntervalWidth * 0.5) pos++
        return pos
    }

    private fun handleChildView(child: View, moveX: Int) {
        val scale = computeScale(moveX)
        val rotationY = computeRotationY(moveX)

        child.scaleX = scale
        child.scaleY = scale

        child.rotationY = rotationY
    }

    /**
     * 计算缩放因子
     */
    private fun computeScale(moveX: Int): Float {
        var scale = 1 - abs(moveX * 1.0f / (8f * mIntervalWidth))
        if (scale < 0f) scale = 0f
        if (scale > 1f) scale = 1f
        return scale
    }

    /**
     * 最大Y轴旋转度数
     */
    private val M_MAX_ROTATION_Y = 30.0f

    /**
     * 计算绕Y轴旋转因子
     */
    private fun computeRotationY(x: Int): Float {
        var rotationY: Float
        rotationY = -M_MAX_ROTATION_Y * x / mIntervalWidth
        if (abs(rotationY) > M_MAX_ROTATION_Y) {
            rotationY = if (rotationY > 0) {
                M_MAX_ROTATION_Y
            } else {
                -M_MAX_ROTATION_Y
            }
        }
        return rotationY
    }


    private fun getMaxOffset(): Int {
        return (itemCount - 1) * mIntervalWidth
    }

    fun calculateDistance(velocityX: Int, distance: Double): Double {
        val extra: Int = mSumDx % mIntervalWidth
        val realDistance: Double
        realDistance = if (velocityX > 0) {
            if (distance < mIntervalWidth) {
                (mIntervalWidth - extra).toDouble()
            } else {
                distance - distance % mIntervalWidth - extra
            }
        } else {
            if (distance < mIntervalWidth) {
                extra.toDouble()
            } else {
                distance - distance % mIntervalWidth + extra
            }
        }
        return realDistance
    }


    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }
}