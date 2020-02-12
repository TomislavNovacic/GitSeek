package com.tomislav.novacic.gitseek.ui.user.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tomislav.novacic.gitseek.R
import com.tomislav.novacic.gitseek.data.model.User
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class UserDetailsFragment : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: UserDetailsViewModel

    companion object {

        private const val KEY_USER_DATA = "KEY_USER_DATA"

        fun newInstance(user: User): UserDetailsFragment {
            val fragment = UserDetailsFragment()
            val arguments = Bundle().apply { putParcelable(KEY_USER_DATA, user) }
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserDetailsViewModel::class.java)
    }
}
