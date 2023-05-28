package com.example.floating_animation_recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring and initializing the
        // RecyclerView from the layout file
        val mRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_1)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        // Generating data (array of strings)
        val mDataArray = mGenerateData()

        // Initializing the adapter
        val mAdapter = MyAdapter(mDataArray)

        // Declaring and initializing the
        // Floating Button from the layout file
        val mFloatingButton = findViewById<FloatingActionButton>(R.id.floating_button_1)

        // When Button is clicked, animation is applied
        // to the RecyclerView and RecyclerView is displayed
        mFloatingButton.setOnClickListener{
            val controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_right_to_left)
            mRecyclerView.layoutAnimation = controller
            mAdapter.notifyDataSetChanged()
            mRecyclerView.scheduleLayoutAnimation()
            mRecyclerView.adapter = mAdapter
        }
    }

    // Sample function to return array
    // of strings (Item 1, Item 2, Item 3,.....)
    private fun mGenerateData(): ArrayList<String> {
        val mArrayList = arrayListOf<String>()
        for (i in 0..10) {
            mArrayList.add("Item $i")
        }
        return mArrayList
    }
}
