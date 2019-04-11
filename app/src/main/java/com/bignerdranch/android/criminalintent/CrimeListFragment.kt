package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * @author Artem Nekrasov
 */
class CrimeListFragment : Fragment() {
    private lateinit var mCrimeRecyclerView: RecyclerView
    private lateinit var mAdapter: CrimeAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_crime_list, container, false)
        mCrimeRecyclerView = view!!.findViewById(R.id.crime_recycler_view)
        mCrimeRecyclerView.layoutManager = LinearLayoutManager(activity)

        updateUI()

        return view
    }

    private class CrimeAdapter(crimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>() {

        private val mCrimes: List<Crime> = crimes

        override fun getItemCount(): Int {
            return mCrimes.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            return CrimeHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: CrimeHolder?, position: Int) {
            holder?.bind(mCrimes[position])
        }

    }

    class CrimeHolder(inflater: LayoutInflater?, parent: ViewGroup?) : RecyclerView.ViewHolder(inflater?.inflate(R.layout.list_item_crime, parent, false)) {

        private var mTitleTextView: TextView = itemView.findViewById(R.id.crime_title)
        private var mDateTextView: TextView = itemView.findViewById(R.id.crime_date)
        private lateinit var mCrime: Crime

        init {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, mCrime.title, Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(crime: Crime) {
            mCrime = crime
            mTitleTextView.text = mCrime.title
            mDateTextView.text = mCrime.date.toString()
        }
    }

    private fun updateUI() {
        val crimeLab = CrimeLab.get(activity)
        val crimes = crimeLab!!.crimes
        mAdapter = CrimeAdapter(crimes)
        mCrimeRecyclerView.adapter = mAdapter
    }
}