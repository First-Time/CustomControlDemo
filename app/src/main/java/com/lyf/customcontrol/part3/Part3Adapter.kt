package com.lyf.customcontrol.part3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lyf.customcontrol.R
import com.lyf.customcontrol.part3.flowlayout02.MyFlowLayoutActivity
import com.lyf.customcontrol.part3.itemdecoration05.divideritemdecoration.ItemDecorationActivity
import com.lyf.customcontrol.part3.itemdecoration05.getitemoffsets.GetItemOffsetsActivity
import com.lyf.customcontrol.part3.itemdecoration05.ondraw.OnDrawActivity
import com.lyf.customcontrol.part3.itemdecoration05.ondrawover.OnDrawOverActivity
import com.lyf.customcontrol.part3.layoutmanager06.CustomLayoutManagerActivity
import com.lyf.customcontrol.part3.measurelayout01.MyLinLayoutActivity
import com.lyf.customcontrol.part3.recyclerreuse07.custom.RecyclerViewCustomActivity
import com.lyf.customcontrol.part3.recyclerreuse07.official.RecyclerViewOfficialActivity
import com.lyf.customcontrol.part3.recyclerreuse07.reusecustom.ReuseCustomActivity
import com.lyf.customcontrol.part3.recyclerview04.RecyclerViewBaseActivity
import com.lyf.customcontrol.part3.waterfalllayout03.WaterFallLayoutActivity

class Part3Adapter(private var activities: ArrayList<String>) :
    RecyclerView.Adapter<Part3Adapter.JumpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JumpViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_part2_activity, parent, false)
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
                            MyLinLayoutActivity::class.java
                        )
                    )
                }
                1 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MyFlowLayoutActivity::class.java
                        )
                    )
                }
                2 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            WaterFallLayoutActivity::class.java
                        )
                    )
                }
                3 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RecyclerViewBaseActivity::class.java
                        )
                    )
                }
                4 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ItemDecorationActivity::class.java
                        )
                    )
                }
                5 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            GetItemOffsetsActivity::class.java
                        )
                    )
                }
                6 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            OnDrawActivity::class.java
                        )
                    )
                }
                7 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            OnDrawOverActivity::class.java
                        )
                    )
                }
                8 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            CustomLayoutManagerActivity::class.java
                        )
                    )
                }
                9 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RecyclerViewOfficialActivity::class.java
                        )
                    )
                }
                10 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RecyclerViewCustomActivity::class.java
                        )
                    )
                }
                11 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ReuseCustomActivity::class.java
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