package com.ninthsemester.stylingandroidanimations

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
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
    private lateinit var mScene3: Scene


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            //  The container in which grids will be added.
            mContainer = container
            mTransitionManager = TransitionManager()

            //  We initialize the the three scenes here.
            mScene1 = Scene.getSceneForLayout(mContainer, R.layout.grid1, this)
            mScene2 = Scene.getSceneForLayout(mContainer, R.layout.grid2, this)
            mScene3 = Scene.getSceneForLayout(mContainer, R.layout.grid3, this)

            //  Based on the scene which is setup, we add click listener to particular view.
            mScene1.setEnterAction {
                mScene1.sceneRoot.findViewById<View>(R.id.item2).setOnClickListener(this)
                mScene1.sceneRoot.findViewById<View>(R.id.item3).setOnClickListener(this)
            }

            mScene2.setEnterAction {
                mScene2.sceneRoot.findViewById<View>(R.id.item1).setOnClickListener(this)
                mScene2.sceneRoot.findViewById<View>(R.id.item3).setOnClickListener(this)
            }

            mScene3.setEnterAction {
                mScene3.sceneRoot.findViewById<View>(R.id.item1).setOnClickListener(this)
                mScene3.sceneRoot.findViewById<View>(R.id.item2).setOnClickListener(this)
            }


            //  We are going to transition by changing Bounds. This
            //  thing gives us that fancy animation of moving items between places.
            val transition = ChangeBounds()

            //  adding all possible transitions in transition manager
            mTransitionManager.setTransition(mScene1, mScene2, transition)
            mTransitionManager.setTransition(mScene1, mScene3, transition)
            mTransitionManager.setTransition(mScene2, mScene1, transition)
            mTransitionManager.setTransition(mScene2, mScene3, transition)
            mTransitionManager.setTransition(mScene3, mScene1, transition)
            mTransitionManager.setTransition(mScene3, mScene2, transition)

            //  Setting scene 1 initially.
            mScene1.enter()

        }


    }

    override fun onClick(v: View?) {

        //  If a particular view is clicked, we transition to another
        //  scene based on which item was clicked.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            when (v?.id) {
                R.id.item1 -> mTransitionManager.transitionTo(mScene1)
                R.id.item2 -> mTransitionManager.transitionTo(mScene2)
                R.id.item3 -> mTransitionManager.transitionTo(mScene3)
            }
        }
    }
}
