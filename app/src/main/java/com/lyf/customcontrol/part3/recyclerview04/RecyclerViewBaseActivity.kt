package com.lyf.customcontrol.part3.recyclerview04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_recycler_view_base.*

class RecyclerViewBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_base)

        val dataList = getData()

        //线性布局
        val layoutManager = LinearLayoutManager(this)

        //网格布局
//        val layoutManager = GridLayoutManager(this, 3)

        //竖向滚动
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        //横向滚动
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        //瀑布流布局
//        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        recyclerView.layoutManager = layoutManager

        val myAdapter = RecyclerViewAdapter(dataList)
        recyclerView.adapter = myAdapter
    }

    private fun getData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0..50) {
            list.add("第${i}组")
            for (j in 1..9) {
                list.add("第${i}${j}个item")
            }
        }
        return list
    }
}