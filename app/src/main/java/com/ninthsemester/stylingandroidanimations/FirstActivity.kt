package com.ninthsemester.stylingandroidanimations

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        NextButton.setOnClickListener {
            startActivity(Intent(FirstActivity@this, SecondActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
        }

    }

}
