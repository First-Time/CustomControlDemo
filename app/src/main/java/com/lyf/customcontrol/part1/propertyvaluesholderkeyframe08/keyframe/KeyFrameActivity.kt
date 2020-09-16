package com.lyf.customcontrol.part1.propertyvaluesholderkeyframe08.keyframe

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_key_frame.*

class KeyFrameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_frame)

        //KeyFrame用法示例
        /*val keyFrame0 = Keyframe.ofFloat(0f, 0f)
        val keyFrame1 = Keyframe.ofFloat(0.1f, 20f)
        val keyFrame2 = Keyframe.ofFloat(0.2f, -20f)
        val keyFrame3 = Keyframe.ofFloat(0.3f, 20f)
        val keyFrame4 = Keyframe.ofFloat(0.4f, -20f)
        val keyFrame5 = Keyframe.ofFloat(0.5f, 20f)
        val keyFrame6 = Keyframe.ofFloat(0.6f, -20f)
        val keyFrame7 = Keyframe.ofFloat(0.7f, 20f)
        val keyFrame8 = Keyframe.ofFloat(0.8f, -20f)
        val keyFrame9 = Keyframe.ofFloat(0.9f, 20f)
        val keyFrame10 = Keyframe.ofFloat(1f, 0f)
        val propertyValuesHolder = PropertyValuesHolder.ofKeyframe(
            "rotation",
            keyFrame0,
            keyFrame1,
            keyFrame2,
            keyFrame3,
            keyFrame4,
            keyFrame5,
            keyFrame6,
            keyFrame7,
            keyFrame8,
            keyFrame9,
            keyFrame10
        )

        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder)
        objectAnimator.duration = 2000
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }*/

        //没有插值器
        /*val keyFrame0 = Keyframe.ofFloat(0f, 0f)
        val keyFrame1 = Keyframe.ofFloat(0.5f, 100f)
        val keyFrame2 = Keyframe.ofFloat(1f)
        keyFrame2.value = 0f
        val propertyValuesHolder =
            PropertyValuesHolder.ofKeyframe("rotation", keyFrame0, keyFrame1, keyFrame2)


        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder)
        objectAnimator.duration = 2000
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }*/

        //使用插值器
        /*val keyFrame0 = Keyframe.ofFloat(0f, 0f)
        val keyFrame1 = Keyframe.ofFloat(0.5f, 100f)
        val keyFrame2 = Keyframe.ofFloat(1f)
        keyFrame2.value = 0f
        keyFrame2.interpolator = BounceInterpolator()
        val propertyValuesHolder =
            PropertyValuesHolder.ofKeyframe("rotation", keyFrame0, keyFrame1, keyFrame2)


        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder)
        objectAnimator.duration = 2000
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }*/

        //字母
        /*val keyFrame0 = Keyframe.ofObject(0f, 'A')
        val keyFrame1 = Keyframe.ofObject(0.1f, 'L')
        val keyFrame2 = Keyframe.ofObject(1f, 'Z')
        val propertyValuesHolder =
            PropertyValuesHolder.ofKeyframe("charText", keyFrame0, keyFrame1, keyFrame2)
        propertyValuesHolder.setEvaluator(CharEvaluator())

        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(textView, propertyValuesHolder)
        objectAnimator.duration = 4000
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }*/

        //去掉第0帧（将以第一帧为起始位置）
        /*val keyFrame1 = Keyframe.ofFloat(0.5f, 100f)
        val keyFrame2 = Keyframe.ofFloat(1f, 1f)
        val propertyValuesHolder =
            PropertyValuesHolder.ofKeyframe("rotation", keyFrame1, keyFrame2)


        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder)
        objectAnimator.duration = 2000
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }*/

        //去掉最后一帧（动画执行到设置的最后一帧的状态后停止，然后等待动画时间完成，在等待动画完成的过程中，动画会在后台安装设置的最后两帧的速率继续执行，在动画时间结束时瞬间变化到最终的状态）
        /*val keyFrame0 = Keyframe.ofFloat(0f, 0f)
        val keyFrame1 = Keyframe.ofFloat(0.2f, 9f)
        val keyFrame2 = Keyframe.ofFloat(0.4f, 27f)
        val propertyValuesHolder =
            PropertyValuesHolder.ofKeyframe("rotation", keyFrame0, keyFrame1, keyFrame2)

        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder)
        objectAnimator.duration = 2000
        objectAnimator.interpolator = AccelerateInterpolator()
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }*/

        //只保留中间帧（崩：java.lang.ArrayIndexOutOfBoundsException: length=1; index=1）
        //报错问题是数组越界，也就是说，至少要有两个帧才行。（只有第0帧、只有最后一帧都会报数组越界）
        /*val keyFrame1 = Keyframe.ofFloat(0.2f, 9f)
        val propertyValuesHolder =
            PropertyValuesHolder.ofKeyframe("rotation", keyFrame1)

        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder)
        objectAnimator.duration = 2000
        objectAnimator.interpolator = AccelerateInterpolator()
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }*/

        //保留两个中间帧（去掉第0帧和最后一帧）（动画执行到设置的最后一帧的状态后停止，然后等待动画时间完成，在等待动画完成的过程中，动画会在后台安装设置的最后两帧的速率继续执行，在动画时间结束时瞬间变化到最终的状态）
        /*val keyFrame1 = Keyframe.ofFloat(0.2f, 20f)
        val keyFrame2 = Keyframe.ofFloat(0.4f, 90f)
        val propertyValuesHolder =
            PropertyValuesHolder.ofKeyframe("rotation", keyFrame1, keyFrame2)

        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder)
        objectAnimator.duration = 4000
        objectAnimator.interpolator = AccelerateInterpolator()
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }*/

        //增加放大动画
        //rotation
        val keyFrame0 = Keyframe.ofFloat(0f, 0f)
        val keyFrame1 = Keyframe.ofFloat(0.1f, 20f)
        val keyFrame2 = Keyframe.ofFloat(0.2f, -20f)
        val keyFrame3 = Keyframe.ofFloat(0.3f, 20f)
        val keyFrame4 = Keyframe.ofFloat(0.4f, -20f)
        val keyFrame5 = Keyframe.ofFloat(0.5f, 20f)
        val keyFrame6 = Keyframe.ofFloat(0.6f, -20f)
        val keyFrame7 = Keyframe.ofFloat(0.7f, 20f)
        val keyFrame8 = Keyframe.ofFloat(0.8f, -20f)
        val keyFrame9 = Keyframe.ofFloat(0.9f, 20f)
        val keyFrame10 = Keyframe.ofFloat(1f, 0f)
        val propertyValuesHolder = PropertyValuesHolder.ofKeyframe(
            "rotation",
            keyFrame0,
            keyFrame1,
            keyFrame2,
            keyFrame3,
            keyFrame4,
            keyFrame5,
            keyFrame6,
            keyFrame7,
            keyFrame8,
            keyFrame9,
            keyFrame10
        )

        //scaleX
        val scaleXKeyFrame0 = Keyframe.ofFloat(0f, 1f)
        val scaleXKeyFrame1 = Keyframe.ofFloat(0.1f, 1.1f)
        val scaleXKeyFrame2 = Keyframe.ofFloat(0.2f, 1.1f)
        val scaleXKeyFrame3 = Keyframe.ofFloat(0.3f, 1.1f)
        val scaleXKeyFrame4 = Keyframe.ofFloat(0.4f, 1.1f)
        val scaleXKeyFrame5 = Keyframe.ofFloat(0.5f, 1.1f)
        val scaleXKeyFrame6 = Keyframe.ofFloat(0.6f, 1.1f)
        val scaleXKeyFrame7 = Keyframe.ofFloat(0.7f, 1.1f)
        val scaleXKeyFrame8 = Keyframe.ofFloat(0.8f, 1.1f)
        val scaleXKeyFrame9 = Keyframe.ofFloat(0.9f, 1.1f)
        val scaleXKeyFrame10 = Keyframe.ofFloat(1f, 1f)
        val scaleXPropertyValuesHolder = PropertyValuesHolder.ofKeyframe(
            "scaleX",
            scaleXKeyFrame0,
            scaleXKeyFrame1,
            scaleXKeyFrame2,
            scaleXKeyFrame3,
            scaleXKeyFrame4,
            scaleXKeyFrame5,
            scaleXKeyFrame6,
            scaleXKeyFrame7,
            scaleXKeyFrame8,
            scaleXKeyFrame9,
            scaleXKeyFrame10
        )

        //scaleY
        val scaleYKeyFrame0 = Keyframe.ofFloat(0f, 1f)
        val scaleYKeyFrame1 = Keyframe.ofFloat(0.1f, 1.1f)
        val scaleYKeyFrame2 = Keyframe.ofFloat(0.2f, 1.1f)
        val scaleYKeyFrame3 = Keyframe.ofFloat(0.3f, 1.1f)
        val scaleYKeyFrame4 = Keyframe.ofFloat(0.4f, 1.1f)
        val scaleYKeyFrame5 = Keyframe.ofFloat(0.5f, 1.1f)
        val scaleYKeyFrame6 = Keyframe.ofFloat(0.6f, 1.1f)
        val scaleYKeyFrame7 = Keyframe.ofFloat(0.7f, 1.1f)
        val scaleYKeyFrame8 = Keyframe.ofFloat(0.8f, 1.1f)
        val scaleYKeyFrame9 = Keyframe.ofFloat(0.9f, 1.1f)
        val scaleYKeyFrame10 = Keyframe.ofFloat(1f, 1f)
        val scaleYPropertyValuesHolder = PropertyValuesHolder.ofKeyframe(
            "scaleY",
            scaleYKeyFrame0,
            scaleYKeyFrame1,
            scaleYKeyFrame2,
            scaleYKeyFrame3,
            scaleYKeyFrame4,
            scaleYKeyFrame5,
            scaleYKeyFrame6,
            scaleYKeyFrame7,
            scaleYKeyFrame8,
            scaleYKeyFrame9,
            scaleYKeyFrame10
        )

        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            imageView,
            propertyValuesHolder,
            scaleXPropertyValuesHolder,
            scaleYPropertyValuesHolder
        )
        objectAnimator.duration = 2000
        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }
    }
}