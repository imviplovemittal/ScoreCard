package com.wisopt.scorecard

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    object statified{
        var context : Context ?= null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statified.context = baseContext
        val subjectList = ArrayList<SubjectData>()
        SubjectAdapter.Statified.scoreList.add(ScoreData(24,25,"CT1"))
        SubjectAdapter.Statified.scoreList.add(ScoreData(12,25,"CT2"))
        subjectList.add(SubjectData("15CS205J","THEORY",SubjectAdapter.Statified.scoreList[0]))
        subjectList.add(SubjectData("15CS201","THEORY",SubjectAdapter.Statified.scoreList[0]))
        subjectList.add(SubjectData("15SE204","THEORY",SubjectAdapter.Statified.scoreList[0]))
        subjectList.add(SubjectData("15MA208","THEORY",SubjectAdapter.Statified.scoreList[0]))
        subjectList.add(SubjectData("15CS202J","LAB",SubjectAdapter.Statified.scoreList[0]))
        scoreRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        scoreRecyclerView.adapter = SubjectAdapter(subjectList)
    }
}
