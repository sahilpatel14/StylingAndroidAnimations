package com.ninthsemester.stylingandroidanimations


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_second.view.*


/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_second, container, false)
                    .apply {
                        BackButton.setOnClickListener(goBack())
                    }


    private fun goBack() : (View) -> Unit = {
        activity ?. supportFragmentManager ?. popBackStackImmediate()
    }

}// Required empty public constructor
