package com.tomislav.novacic.gitseek.ui.repository.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tomislav.novacic.gitseek.R
import com.tomislav.novacic.gitseek.data.model.Repository
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class RepositoryDetailsFragment : Fragment() {

    //TODO Add recyclerView to show repository details
    //TODO Add implicit intent to open browser

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: RepositoryDetailsViewModel

    companion object {

        private const val KEY_REPOSITORY_DATA = "KEY_REPOSITORY_DATA"

        fun newInstance(repository: Repository): RepositoryDetailsFragment {
            val fragment = RepositoryDetailsFragment()
            val arguments = Bundle().apply { putParcelable(KEY_REPOSITORY_DATA, repository) }
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repository_details, container, false)
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepositoryDetailsViewModel::class.java)
    }
}
