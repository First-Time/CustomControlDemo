package com.lyf.customcontrol.part1.listviewitementeranimator13

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_list_view_item_enter_animator.*

class ListViewItemEnterAnimatorActivity : AppCompatActivity() {

    private var drawables = ArrayList<Drawable>()
    private lateinit var listViewAdapter: ListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_item_enter_animator)

        drawables.add(resources.getDrawable(R.drawable.img_1)!!)
        drawables.add(resources.getDrawable(R.drawable.img_2)!!)
        drawables.add(resources.getDrawable(R.drawable.img_3)!!)
        drawables.add(resources.getDrawable(R.drawable.img_4)!!)
        drawables.add(resources.getDrawable(R.drawable.img_5)!!)
        drawables.add(resources.getDrawable(R.drawable.img_6)!!)
        drawables.add(resources.getDrawable(R.drawable.img_7)!!)
        drawables.add(resources.getDrawable(R.drawable.img_8)!!)
        drawables.add(resources.getDrawable(R.drawable.img_9)!!)


        listViewAdapter = ListViewAdapter(this, listView, drawables, 300)

        listView.adapter = listViewAdapter
    }
}