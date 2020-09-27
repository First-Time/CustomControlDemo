package com.lyf.customcontrol.part3.itemdecoration05.divideritemdecoration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_item_decoration.*

class ItemDecorationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_decoration)

        val dataList = getData()

        //线性布局
        val layoutManager = LinearLayoutManager(this)
        //竖向滚动
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

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