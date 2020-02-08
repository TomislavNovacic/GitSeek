package com.tomislav.novacic.gitseek.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tomislav.novacic.gitseek.R
import com.tomislav.novacic.gitseek.ui.search.SearchFragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    private val SEARCH_FRAGMENT_TAG = "SEARCH_FRAGMENT_TAG"

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> = dispatchingAndroidInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, SearchFragment.newInstance(), SEARCH_FRAGMENT_TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
