package com.wisopt.scorecard

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.score_element.view.*

/**
 * Created by viplo on 03-Feb-18.
 */
class SubjectAdapter (val subjectList: ArrayList<SubjectData>): RecyclerView.Adapter<SubjectAdapter.ViewHolder>()  {
    object Statified{
        var scoreList = ArrayList<ScoreData>()
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)

        val feedView = inflater.inflate(R.layout.score_element, parent, false)
        val viewholder = ViewHolder(feedView)

        return viewholder
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(subjectList[position])
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {
        fun bindData(subjectData : SubjectData){
            itemView.subCode.text = subjectData.subCode
            itemView.score_space.layoutManager = LinearLayoutManager(MainActivity.statified.context, LinearLayout.HORIZONTAL,false)
            itemView.score_space.adapter = ScoreAdapter(Statified.scoreList)
            itemView.subType.text = subjectData.type
        }
    }
}