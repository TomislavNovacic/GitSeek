package com.tomislav.novacic.gitseek.di.module

import com.tomislav.novacic.gitseek.ui.repository.details.RepositoryDetailsFragment
import com.tomislav.novacic.gitseek.ui.search.SearchFragment
import com.tomislav.novacic.gitseek.ui.user.details.UserDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun contributeRepositoryDetailsFragment(): RepositoryDetailsFragment

    @ContributesAndroidInjector
    abstract fun contributeUserDetailsFragment(): UserDetailsFragment
}