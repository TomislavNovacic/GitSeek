package com.tomislav.novacic.gitseek.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tomislav.novacic.gitseek.R


class MainActivity : AppCompatActivity() {

    private val MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, MainFragment.newInstance(), MAIN_FRAGMENT_TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
