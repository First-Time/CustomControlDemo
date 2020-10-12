package com.lyf.customcontrol.part3.recyclercoverflow09.normal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.lyf.customcontrol.R

class CoverFlowAdapter(val context: Context, val dataList: ArrayList<String>) :
    RecyclerView.Adapter<CoverFlowAdapter.NormalHolder>() {

    private var mCreateHolder = 0
    private val mPics = arrayListOf(
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6
    )

    class NormalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val index: AppCompatTextView = itemView.findViewById(R.id.index)
        val imageView: AppCompatImageView = itemView.findViewById(R.id.imageView)

        init {
            index.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    index.text,
                    Toast.LENGTH_LONG
                ).show()
            }

            imageView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    index.text,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalHolder {
        mCreateHolder++
        val view = LayoutInflater.from(context).inflate(R.layout.item_cover_flow, parent, false)
        return NormalHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: NormalHolder, position: Int) {
        holder.index.text = dataList[position]
        holder.imageView.setImageDrawable(context.resources.getDrawable(mPics[position % mPics.size]))
    }
}