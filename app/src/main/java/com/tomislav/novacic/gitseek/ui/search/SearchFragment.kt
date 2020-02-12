package com.tomislav.novacic.gitseek.ui.search

import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.tomislav.novacic.gitseek.R
import com.tomislav.novacic.gitseek.data.OnClick
import com.tomislav.novacic.gitseek.data.RepositoriesAdapter
import com.tomislav.novacic.gitseek.data.model.Repository
import com.tomislav.novacic.gitseek.data.model.User
import com.tomislav.novacic.gitseek.ui.repository.details.RepositoryDetailsFragment
import com.tomislav.novacic.gitseek.ui.user.details.UserDetailsFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject


class SearchFragment : Fragment(), OnClick {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: SearchViewModel
    private lateinit var repositoriesAdapter: RepositoriesAdapter

    private val REPOSITORY_DETAILS_FRAGMENT_TAG = "REPOSITORY_DETAILS_FRAGMENT_TAG"
    private val USER_DETAILS_FRAGMENT_TAG = "USER_DETAILS_FRAGMENT_TAG"

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.response.observe(viewLifecycleOwner, Observer {
            if (it?.repositoryDetailsList != null) {
                repositoriesAdapter.data = ArrayList(it.repositoryDetailsList)
                repositoriesAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        searchKeywords.setOnEditorActionListener { view, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.searchKeyword.value = view.text.toString()
            }
            false
        }
        repositoriesAdapter = RepositoriesAdapter(ArrayList(), this)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayout.VERTICAL))
        recyclerView.adapter = repositoriesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort_by_best_match -> {
                viewModel.sortOption.value = SortOption.BEST_MATCH.value
                item.isChecked = !item.isChecked
                return true
            }
            R.id.action_sort_by_stars -> {
                viewModel.sortOption.value = SortOption.STARS.value
                item.isChecked = !item.isChecked
                return true
            }
            R.id.action_sort_by_forks -> {
                viewModel.sortOption.value = SortOption.FORKS.value
                item.isChecked = !item.isChecked
                return true
            }
            R.id.action_sort_by_updated -> {
                viewModel.sortOption.value = SortOption.UPDATED.value
                item.isChecked = !item.isChecked
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRepositoryClick(repository: Repository) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.container, RepositoryDetailsFragment.newInstance(repository), REPOSITORY_DETAILS_FRAGMENT_TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onThumbnailClick(user: User) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.container, UserDetailsFragment.newInstance(user), USER_DETAILS_FRAGMENT_TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
