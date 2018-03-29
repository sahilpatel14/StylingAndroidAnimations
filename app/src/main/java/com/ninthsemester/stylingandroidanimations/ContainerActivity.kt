package com.ninthsemester.stylingandroidanimations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        with(supportFragmentManager) {
            takeIf { backStackEntryCount == 0 }
                    ?. apply {
                        with(beginTransaction()) {
                            addToBackStack("first")
                            add(R.id.container, FirstFragment())
                            commit()
                        }
                    }
        }
    }

    override fun onBackPressed() {
        when(supportFragmentManager.backStackEntryCount) {
            1 -> finish()
            2 -> supportFragmentManager.popBackStackImmediate()
            else -> super.onBackPressed()
        }
    }

}
