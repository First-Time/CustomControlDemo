package com.lyf.customcontrol.part1.layoutanimation11.listviewanimation

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_list_view_animation_code.*

class ListViewAnimationCodeActivity : AppCompatActivity() {
    private lateinit var mAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_animation_code)

        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        val layoutAnimationController = LayoutAnimationController(animation, 1f)
        layoutAnimationController.order = LayoutAnimationController.ORDER_REVERSE

        listView.layoutAnimation = layoutAnimationController

        mAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, getData())
        listView.adapter = mAdapter

        btn_load_data.setOnClickListener { mAdapter.addAll(getData()) }
    }

    private fun getData(): List<String> {
        val listView = ArrayList<String>()
        listView.add("测试数据1")
        listView.add("测试数据2")
        listView.add("测试数据3")
        listView.add("测试数据4")
        listView.add("测试数据5")
        listView.add("测试数据6")
        listView.add("测试数据7")
        listView.add("测试数据8")
        listView.add("测试数据9")
        listView.add("测试数据10")
        return listView
    }
}