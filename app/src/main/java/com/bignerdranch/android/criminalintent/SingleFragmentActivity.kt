package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * @author Artem Nekrasov
 */
abstract class SingleFragmentActivity : AppCompatActivity() {

    abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        var fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = createFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }
}