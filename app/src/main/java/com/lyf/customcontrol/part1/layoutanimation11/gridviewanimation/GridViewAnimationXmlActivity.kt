package com.lyf.customcontrol.part1.layoutanimation11.gridviewanimation

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_grid_view_animation_xml.*

class GridViewAnimationXmlActivity : AppCompatActivity() {

    private val mList = ArrayList<String>()

    private lateinit var mAdapter: MyGridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_animation_xml)

        mList.addAll(getData())
        mAdapter = MyGridAdapter()
        gridView.adapter = mAdapter

        btn_load_data.setOnClickListener {
            mList.addAll(getData())
            mAdapter.notifyDataSetChanged()
        }
    }

    private fun getData(): List<String> {
        val list = ArrayList<String>()
        for (i in 0..30) {
            list.add("DATA + $i")
        }
        return list
    }

    inner class MyGridAdapter : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val textView = TextView(parent?.context)
            textView.text = getItem(position) as String
            textView.layoutParams = AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.WRAP_CONTENT
            )
            textView.setBackgroundColor(Color.RED)
            textView.gravity = Gravity.CENTER
            return textView
        }

        override fun getItem(position: Int): Any {
            return mList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return mList.size
        }

    }
}