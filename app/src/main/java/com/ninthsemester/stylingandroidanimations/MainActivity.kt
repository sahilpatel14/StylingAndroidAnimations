package com.ninthsemester.stylingandroidanimations

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

//  https://blog.stylingandroid.com/transition-animation-part-1/

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mContainer: ViewGroup
    private lateinit var mTransitionManager: TransitionManager

    private lateinit var mScene1: Scene
    private lateinit var mScene2: Scene


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            mContainer = container
            mTransitionManager = TransitionManager()

            mScene1 = Scene.getSceneForLayout(mContainer, R.layout.part3_1, this)
            mScene2 = Scene.getSceneForLayout(mContainer, R.layout.part3_2, this)

            mScene1.setEnterAction {
                mScene1.sceneRoot.findViewById<View>(R.id.item_1c).setOnClickListener(this)
            }

            mScene2.setEnterAction {
                mScene2.sceneRoot.findViewById<View>(R.id.item_1a).setOnClickListener(this)
            }


//            val transition = AutoTransition()
//            or
            val transition = TransitionSet()
            transition.ordering = TransitionSet.ORDERING_TOGETHER
            transition.addTransition(ChangeBounds()).addTransition(Fade())
            mTransitionManager.setTransition(mScene1, mScene2, transition)
            mTransitionManager.setTransition(mScene2, mScene1, transition)
            mScene1.enter()

        }


    }

    override fun onClick(v: View?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            when (v?.id) {
                R.id.item_1a -> mTransitionManager.transitionTo(mScene1)
                R.id.item_1c -> mTransitionManager.transitionTo(mScene2)
            }
        }
    }
}
