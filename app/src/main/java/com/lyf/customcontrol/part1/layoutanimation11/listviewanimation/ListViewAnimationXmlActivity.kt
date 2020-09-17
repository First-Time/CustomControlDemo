package com.lyf.customcontrol.part1.layoutanimation11.listviewanimation

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_list_view_animation_xml.*

class ListViewAnimationXmlActivity : AppCompatActivity() {
    private lateinit var mAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_animation_xml)

        mAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, getData())
        listView.adapter = mAdapter

        btn_load_data.setOnClickListener {
            mAdapter.addAll(getData())
        }
    }

    private fun getData(): List<String> {
        val list = ArrayList<String>()
        list.add("测试数据1")
        list.add("测试数据2")
        list.add("测试数据3")
        list.add("测试数据4")
        list.add("测试数据5")
        list.add("测试数据6")
        list.add("测试数据7")
        list.add("测试数据8")
        list.add("测试数据9")
        list.add("测试数据10")
        return list
    }
}