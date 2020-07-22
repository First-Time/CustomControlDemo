package com.lyf.customcontrol.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lyf.customcontrol.R
import com.lyf.customcontrol.part2.draw01.arc.ArcActivity
import com.lyf.customcontrol.part2.draw01.circle.CircleActivity
import com.lyf.customcontrol.part2.draw01.line.LineActivity
import com.lyf.customcontrol.part2.draw01.oval.OvalActivity
import com.lyf.customcontrol.part2.draw01.point.PointActivity
import com.lyf.customcontrol.part2.draw01.rect.RectActivity
import com.lyf.customcontrol.part2.pathquadto06.gesture.lineto.GestureLineToActivity
import com.lyf.customcontrol.part2.pathquadto06.gesture.quadto.GestureQuadToActivity
import com.lyf.customcontrol.part2.pathquadto06.quadratic.QuadraticActivity
import com.lyf.customcontrol.part2.pathquadto06.rquadto.RQuadraticActivity
import com.lyf.customcontrol.part2.pathquadto06.wave.WaveActivity
import com.lyf.customcontrol.part2.pathtext02.path.arc.ArcPathActivity
import com.lyf.customcontrol.part2.pathtext02.path.circle.CirclePathActivity
import com.lyf.customcontrol.part2.pathtext02.path.line.LinePathActivity
import com.lyf.customcontrol.part2.pathtext02.path.oval.OvalPathActivity
import com.lyf.customcontrol.part2.pathtext02.path.quad.QuadPathActivity
import com.lyf.customcontrol.part2.pathtext02.path.rect.RectPathActivity
import com.lyf.customcontrol.part2.pathtext02.path.roundrect.RoundRectPathActivity
import com.lyf.customcontrol.part2.pathtext02.text.example01.TextExample01Activity
import com.lyf.customcontrol.part2.pathtext02.text.example02.TextExample02Activity
import com.lyf.customcontrol.part2.pathtext02.text.example03.TextExample03Activity
import com.lyf.customcontrol.part2.pathtext02.text.path.TextPathActivity
import com.lyf.customcontrol.part2.pathtext02.text.pos.TextPosActivity
import com.lyf.customcontrol.part2.pathtext02.text.typeface.custom.TextTypefaceCustomActivity
import com.lyf.customcontrol.part2.pathtext02.text.typeface.system.TextTypefaceSystemActivity
import com.lyf.customcontrol.part2.region03.construct.RegionConstructActivity
import com.lyf.customcontrol.part2.region03.op.RegionOpActivity
import com.lyf.customcontrol.part2.region03.setpath.RegionSetPathActivity
import com.lyf.customcontrol.part2.region04.clip.ClipActivity
import com.lyf.customcontrol.part2.region04.rotate.RotateActivity
import com.lyf.customcontrol.part2.region04.saverestore.SaveRestoreActivity
import com.lyf.customcontrol.part2.region04.scale.ScaleActivity
import com.lyf.customcontrol.part2.region04.skew.SkewActivity
import com.lyf.customcontrol.part2.region04.translate.TranslateActivity
import com.lyf.customcontrol.part2.text05.fixedpointwrite.center.MyCenterActivity
import com.lyf.customcontrol.part2.text05.fixedpointwrite.top.MyTopTextActivity
import com.lyf.customcontrol.part2.text05.fontmetrics.FontMetricsActivity
import com.lyf.customcontrol.part2.text05.fourlineandbase.BlogDrawActivity
import com.lyf.customcontrol.part2.text05.widthheightrect.WidthHeightActivity

class MainAdapter(private var activities: ArrayList<String>) :
    RecyclerView.Adapter<MainAdapter.JumpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JumpViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_activity, parent, false)
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
                            CircleActivity::class.java
                        )
                    )
                }
                1 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            LineActivity::class.java
                        )
                    )
                }
                2 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PointActivity::class.java
                        )
                    )
                }
                3 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RectActivity::class.java
                        )
                    )
                }
                4 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            OvalActivity::class.java
                        )
                    )
                }
                5 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ArcActivity::class.java
                        )
                    )
                }
                6 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            LinePathActivity::class.java
                        )
                    )
                }
                7 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RectPathActivity::class.java
                        )
                    )
                }
                8 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RoundRectPathActivity::class.java
                        )
                    )
                }
                9 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            CirclePathActivity::class.java
                        )
                    )
                }
                10 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            OvalPathActivity::class.java
                        )
                    )
                }
                11 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ArcPathActivity::class.java
                        )
                    )
                }
                12 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            QuadPathActivity::class.java
                        )
                    )
                }
                13 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextExample01Activity::class.java
                        )
                    )
                }
                14 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextExample02Activity::class.java
                        )
                    )
                }
                15 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextExample03Activity::class.java
                        )
                    )
                }
                16 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextPosActivity::class.java
                        )
                    )
                }
                17 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextPathActivity::class.java
                        )
                    )
                }
                18 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextTypefaceSystemActivity::class.java
                        )
                    )
                }
                19 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextTypefaceCustomActivity::class.java
                        )
                    )
                }
                20 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RegionConstructActivity::class.java
                        )
                    )
                }
                21 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RegionSetPathActivity::class.java
                        )
                    )
                }
                22 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RegionOpActivity::class.java
                        )
                    )
                }
                23 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TranslateActivity::class.java
                        )
                    )
                }
                24 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RotateActivity::class.java
                        )
                    )
                }
                25 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ScaleActivity::class.java
                        )
                    )
                }
                26 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ClipActivity::class.java
                        )
                    )
                }
                27 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            SkewActivity::class.java
                        )
                    )
                }
                28 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            SaveRestoreActivity::class.java
                        )
                    )
                }
                29 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            BlogDrawActivity::class.java
                        )
                    )
                }
                30 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            FontMetricsActivity::class.java
                        )
                    )
                }
                31 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            WidthHeightActivity::class.java
                        )
                    )
                }
                32 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MyTopTextActivity::class.java
                        )
                    )
                }
                33 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MyCenterActivity::class.java
                        )
                    )
                }
                34 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            QuadraticActivity::class.java
                        )
                    )
                }
                35 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            GestureLineToActivity::class.java
                        )
                    )
                }
                36 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            GestureQuadToActivity::class.java
                        )
                    )
                }
                37 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RQuadraticActivity::class.java
                        )
                    )
                }
                38 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            WaveActivity::class.java
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