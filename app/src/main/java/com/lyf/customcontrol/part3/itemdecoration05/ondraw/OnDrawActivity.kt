package com.lyf.customcontrol.part3.itemdecoration05.ondraw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_on_draw.*

class OnDrawActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_draw)

        val dataList = getData()

        //线性布局
        val layoutManager = LinearLayoutManager(this)
        //竖向滚动
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val itemDecoration = LinearItemDecoration(this)
        recyclerView.addItemDecoration(itemDecoration)

        val myAdapter =
            RecyclerViewAdapter(
                dataList
            )
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