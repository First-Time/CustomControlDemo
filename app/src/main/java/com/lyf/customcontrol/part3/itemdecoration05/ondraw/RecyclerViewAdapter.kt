package com.lyf.customcontrol.part3.itemdecoration05.ondraw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.lyf.customcontrol.R

class RecyclerViewAdapter(private var dataList: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mTitleNum = 10

    class TitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: AppCompatTextView = itemView.findViewById(R.id.title)
    }

    class TextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: AppCompatTextView = itemView.findViewById(R.id.textView)

        init {
            textView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    textView.text,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % mTitleNum == 0) ItemType.ITEM_TYPE_TITLE.ordinal else ItemType.ITEM_TYPE_TEXT.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View?
        if (viewType == ItemType.ITEM_TYPE_TITLE.ordinal) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_view_title, parent, false)
            return TitleHolder(
                view!!
            )
        } else {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_view_text, parent, false)
            return TextHolder(
                view!!
            )
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TitleHolder) {
            holder.title.text = dataList[position]
        }
        if (holder is TextHolder) {
            holder.textView.text = dataList[position]
        }
    }

    enum class ItemType {
        ITEM_TYPE_TITLE,
        ITEM_TYPE_TEXT
    }
}