package com.tomislav.novacic.gitseek.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomislav.novacic.gitseek.di.ViewModelFactory
import com.tomislav.novacic.gitseek.ui.repository.details.RepositoyDetailsViewModel
import com.tomislav.novacic.gitseek.ui.search.SearchViewModel
import com.tomislav.novacic.gitseek.ui.user.details.UserDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    protected abstract fun searchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepositoyDetailsViewModel::class)
    protected abstract fun repositoryDetailsViewModel(searchViewModel: RepositoyDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserDetailsViewModel::class)
    protected abstract fun userDetailsViewModel(searchViewModel: UserDetailsViewModel): ViewModel
}