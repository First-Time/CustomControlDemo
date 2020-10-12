package com.lyf.customcontrol.part3.recyclercoverflow09.overlay

import android.content.Context
import android.hardware.SensorManager
import android.util.AttributeSet
import android.view.ViewConfiguration
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.ln


class RecyclerCoverFlowView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    RecyclerView(context, attrs, defStyleAttr) {
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        isChildrenDrawingOrderEnabled = true
    }

    private fun getCoverFlowLayout(): CoverFlowLayoutManager {
        return layoutManager as CoverFlowLayoutManager
    }

    override fun getChildDrawingOrder(childCount: Int, i: Int): Int {
        val center =
            getCoverFlowLayout().getCenterPosition() - getCoverFlowLayout().getFirstVisiblePosition()
        val order: Int
        order = when {
            i == center -> {
                childCount - 1
            }
            i > center -> {
                center + childCount - 1 - i
            }
            else -> {
                i
            }
        }
        println("getChildDrawingOrder childCount:$childCount center:$center i: $i order:$order")
        return order
    }

    override fun fling(velocityX: Int, velocityY: Int): Boolean {
        var flingX = (velocityX * 0.4f).toInt()
        val distance = getSplineFlingDistance(flingX)
        val newDistance = getCoverFlowLayout().calculateDistance(flingX, distance)
        val fixVelocityX = getVelocity(newDistance)
        flingX = if (velocityX > 0) {
            fixVelocityX
        } else {
            -fixVelocityX
        }
        return super.fling(flingX, velocityY)
    }

    /**
     * 根据松手后的滑动速度计算出fling的距离
     *
     * @param velocity
     * @return
     */
    private fun getSplineFlingDistance(velocity: Int): Double {
        val l = getSplineDeceleration(velocity)
        val decelMinusOne = DECELERATION_RATE - 1.0
        return mFlingFriction * getPhysicalCoeff() * exp(DECELERATION_RATE / decelMinusOne * l)
    }

    /**
     * 根据距离计算出速度
     *
     * @param distance
     * @return
     */
    private fun getVelocity(distance: Double): Int {
        val decelMinusOne = DECELERATION_RATE - 1.0
        val aecel =
            ln(distance / (mFlingFriction * mPhysicalCoeff)) * decelMinusOne / DECELERATION_RATE
        return abs((exp(aecel) * (mFlingFriction * mPhysicalCoeff) / INFLEXION).toInt())
    }

    /**
     * --------------fling辅助类---------------
     */
    private val INFLEXION = 0.35f // Tension lines cross at (INFLEXION, 1)

    private val mFlingFriction = ViewConfiguration.getScrollFriction()
    private val DECELERATION_RATE = (ln(0.78) / ln(0.9)).toFloat()
    private var mPhysicalCoeff = 0f

    private fun getSplineDeceleration(velocity: Int): Double {
        val ppi = this.resources.displayMetrics.density * 160.0f
        val mPhysicalCoeff = (SensorManager.GRAVITY_EARTH // g (m/s^2)
                * 39.37f // inch/meter
                * ppi
                * 0.84f) // look and feel tuning
        return ln(INFLEXION * abs(velocity) / (mFlingFriction * mPhysicalCoeff).toDouble())
    }

    private fun getPhysicalCoeff(): Float {
        if (mPhysicalCoeff == 0f) {
            val ppi = this.resources.displayMetrics.density * 160.0f
            mPhysicalCoeff = (SensorManager.GRAVITY_EARTH // g (m/s^2)
                    * 39.37f // inch/meter
                    * ppi
                    * 0.84f) // look and feel tuning
        }
        return mPhysicalCoeff
    }

}