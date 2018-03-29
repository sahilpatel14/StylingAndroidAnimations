package com.ninthsemester.stylingandroidanimations


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_first.view.*


/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_first, container, false)
                    .also {view ->
                        view.NextButton.setOnClickListener {
                            openSecondFragment()
                        }
                    }


    private fun openSecondFragment() {

        activity?.supportFragmentManager?.let {


            with(it.beginTransaction()) {
                setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left,
                        R.anim.slide_in_right, R.anim.slide_out_right)
                addToBackStack("second")
                replace(R.id.container, SecondFragment())
                commit()
            }

        }

    }

}// Required empty public constructor
