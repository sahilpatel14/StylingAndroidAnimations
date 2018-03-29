package com.ninthsemester.stylingandroidanimations

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        twoActivities.setOnClickListener(openActivity(FirstActivity::class.java))
        twoFragments.setOnClickListener(openActivity(ContainerActivity::class.java))
    }



    private fun <T> openActivity(activity: Class<T>) : (View) -> Unit =
            { startActivity(Intent(MainActivity@this, activity)) }

}
