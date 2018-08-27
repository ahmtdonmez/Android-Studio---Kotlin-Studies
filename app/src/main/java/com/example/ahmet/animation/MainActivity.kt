package com.example.ahmet.animation

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainn)


        recyclerView = findViewById(R.id.recycleLeft)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        runAnimation(recyclerView!!,true)

        recyclerView = findViewById(R.id.recycleRight)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        runAnimation(recyclerView!!,false)

    }


    fun runAnimation(recyclerView: RecyclerView, check:Boolean){

        var context: Context = recyclerView!!.context
        var controller: LayoutAnimationController

        if(check)
        controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_from_right)

        else
            controller =AnimationUtils.loadLayoutAnimation(context, R.anim.layout_from_left)

        var adapterx = Animation()

        recyclerView!!.adapter = adapterx

        recyclerView!!.layoutAnimation = controller
        recyclerView!!.adapter.notifyDataSetChanged()
        recyclerView!!.scheduleLayoutAnimation()


    }
}
