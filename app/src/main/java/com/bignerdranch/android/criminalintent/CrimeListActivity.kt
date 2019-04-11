package com.bignerdranch.android.criminalintent

import android.support.v4.app.Fragment

/**
 * @author Artem Nekrasov
 */
class CrimeListActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return CrimeListFragment()
    }
}