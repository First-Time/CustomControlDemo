package com.lyf.customcontrol.part1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lyf.customcontrol.R
import com.lyf.customcontrol.part1.animation01.AnimationActivity
import com.lyf.customcontrol.part1.animation03.AnimationCodeActivity
import com.lyf.customcontrol.part1.interpolator02.InterpolatorActivity
import com.lyf.customcontrol.part1.objectanimator07.ObjectAnimatorActivity
import com.lyf.customcontrol.part1.objectanimator07.customobjectanimator.PointObjectAnimatorActivity
import com.lyf.customcontrol.part1.propertyvaluesholderkeyframe08.keyframe.KeyFrameActivity
import com.lyf.customcontrol.part1.propertyvaluesholderkeyframe08.offloatofint.PropertyValuesHolderActivity
import com.lyf.customcontrol.part1.propertyvaluesholderkeyframe08.ofobject.PropertyValuesHolderOfObjectActivity
import com.lyf.customcontrol.part1.uniteanimatorcode09.UnitAnimatorCodeActivity
import com.lyf.customcontrol.part1.uniteanimatorxml10.*
import com.lyf.customcontrol.part1.valueanimator04.ValueAnimatorBasicActivity
import com.lyf.customcontrol.part1.valueanimator05.ValueAnimatorInterpolatorActivity
import com.lyf.customcontrol.part1.valueanimator06.ValueAnimatorOfObjectActivity
import com.lyf.customcontrol.part1.valueanimator06.customobject.PointObjectActivity

class Part1Adapter(private var activities: ArrayList<String>) :
    RecyclerView.Adapter<Part1Adapter.JumpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JumpViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_part1_activity, parent, false)
        return JumpViewHolder(view)
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    override fun onBindViewHolder(holder: JumpViewHolder, position: Int) {
        val itemStr = activities[position]
        holder.tvNameJump.text = itemStr
//        val random = Random
//        holder.tvNameJump.height = random.nextInt(500, 2000)

        holder.tvNameJump.setOnClickListener {
            when (position) {
                0 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            AnimationActivity::class.java
                        )
                    )
                }
                1 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            InterpolatorActivity::class.java
                        )
                    )
                }
                2 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            AnimationCodeActivity::class.java
                        )
                    )
                }
                3 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ValueAnimatorBasicActivity::class.java
                        )
                    )
                }
                4 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ValueAnimatorInterpolatorActivity::class.java
                        )
                    )
                }
                5 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ValueAnimatorOfObjectActivity::class.java
                        )
                    )
                }
                6 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PointObjectActivity::class.java
                        )
                    )
                }
                7 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ObjectAnimatorActivity::class.java
                        )
                    )
                }
                8 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PointObjectAnimatorActivity::class.java
                        )
                    )
                }
                9 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PropertyValuesHolderActivity::class.java
                        )
                    )
                }
                10 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PropertyValuesHolderOfObjectActivity::class.java
                        )
                    )
                }
                11 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            KeyFrameActivity::class.java
                        )
                    )
                }
                12 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            UnitAnimatorCodeActivity::class.java
                        )
                    )
                }
                13 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ValueAnimatorTranslationXmlActivity::class.java
                        )
                    )
                }
                14 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ValueAnimatorColorXmlActivity::class.java
                        )
                    )
                }
                15 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ObjectAnimatorTranslationXmlActivity::class.java
                        )
                    )
                }
                16 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ObjectAnimatorColorXmlActivity::class.java
                        )
                    )
                }
                17 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            AnimatorSetTranslationXmlActivity::class.java
                        )
                    )
                }
                18 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            AnimatorMenuActivity::class.java
                        )
                    )
                }
            }
        }
    }

    class JumpViewHolder(itemView: View) : ViewHolder(itemView) {
        var tvNameJump: AppCompatTextView = itemView.findViewById(R.id.tv_main_jump)
    }
}