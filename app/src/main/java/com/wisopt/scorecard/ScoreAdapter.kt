package com.wisopt.scorecard

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.indivisual_scores.view.*

/**
 * Created by viplo on 03-Feb-18.
 */
class ScoreAdapter (val userList: ArrayList<ScoreData>): RecyclerView.Adapter<ScoreAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)

        val feedView = inflater.inflate(R.layout.indivisual_scores, parent, false)
        val viewholder = ViewHolder(feedView)

        return viewholder
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(userList[position])
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {
        fun bindData(scoreData : ScoreData){
            itemView.marks.text = (itemView.marks.text as String).format(scoreData.marksGot,scoreData.totalMarks)
            itemView.exam_name.text = scoreData.examName
            if((scoreData.marksGot.toDouble()/scoreData.totalMarks.toDouble())<=0.55){
                itemView.marks.setBackgroundColor(Color.parseColor("#FF6666"))
            }
            else if((scoreData.marksGot.toDouble()/scoreData.totalMarks.toDouble())>0.85){
                itemView.marks.setBackgroundColor(Color.parseColor("#99FF33"))
            }
        }
    }
}