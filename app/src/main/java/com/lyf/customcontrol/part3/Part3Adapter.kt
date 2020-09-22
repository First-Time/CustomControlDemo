package com.lyf.customcontrol.part3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lyf.customcontrol.R
import com.lyf.customcontrol.part3.measurelayout01.MyLinLayoutActivity

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
            }
        }
    }

    class JumpViewHolder(itemView: View) : ViewHolder(itemView) {
        var tvNameJump: AppCompatTextView = itemView.findViewById(R.id.tv_main_jump)
    }
}