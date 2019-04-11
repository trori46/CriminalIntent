package com.bignerdranch.android.criminalintent

import java.util.*

/**
 * @author Artem Nekrasov
 */
class Crime {
    val id: UUID = UUID.randomUUID()
    lateinit var title: String
    var date = Date()
    var solved: Boolean = false

}