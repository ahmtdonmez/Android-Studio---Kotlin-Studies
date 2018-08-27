package com.example.ahmet.animation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.logging.Handler

/**
 * Created by Ahmet on 8.08.2018.
 */
class Animation: RecyclerView.Adapter<Animation.Holder> {

    private var list: ArrayList<Int>?= null

    constructor(){

        var i = 0
        list = ArrayList()

        while(i<6){

            list!!.add(i)
            i++
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {

        var view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.recyclelist_item, parent, false)

        return Holder(view)

    }

    override fun getItemCount(): Int {

        return list!!.size

    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {

//        holder!!.textView!!.text = list!!.get(position).toString()

        if(position == 1)   //setting one button
        {
            holder!!.button!!.text = "Dictionary"

        }
        holder!!.button!!.setOnClickListener {  // to show how to make on click method

            if(holder!!.button!!.text == "Dictionary"){
                Toast.makeText(holder!!.button!!.context, "Dictionary clicked", Toast.LENGTH_LONG).show()
            }


        }



    }


     class Holder: RecyclerView.ViewHolder{

        var textView: TextView ?= null
        var button: Button ?= null

        constructor(view: View) : super(view) {
          //  this.textView = view.findViewById<TextView>(R.id.textVieww)


            button = view.findViewById(R.id.buttons)

        }



    }



}