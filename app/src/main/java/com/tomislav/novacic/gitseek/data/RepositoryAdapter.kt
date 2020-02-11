package com.tomislav.novacic.gitseek.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tomislav.novacic.gitseek.R
import com.tomislav.novacic.gitseek.data.model.Repository
import com.tomislav.novacic.gitseek.data.model.User

class RepositoriesAdapter(var data: ArrayList<Repository>, private val onClick: OnClick) : RecyclerView.Adapter<RepositoriesAdapter.RepositoryViewHolder>() {

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mItem: ConstraintLayout = itemView.findViewById(R.id.container)
        val mThumbnail: ImageView = itemView.findViewById(R.id.avatar)
        val mRepositoryName: TextView = itemView.findViewById(R.id.repositoryName)
        val mUserName: TextView = itemView.findViewById(R.id.userName)
        val mWatchersCount: TextView = itemView.findViewById(R.id.watchersCount)
        val mForkCount: TextView = itemView.findViewById(R.id.forkCount)
        val mIssueCount: TextView = itemView.findViewById(R.id.issueCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false))
    }

    override fun onBindViewHolder(viewHolder: RepositoryViewHolder, position: Int) {
        Glide.with(viewHolder.itemView.context)
            .load(data[position].owner.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(viewHolder.mThumbnail)
        viewHolder.mRepositoryName.text = data[position].name
        viewHolder.mUserName.text = data[position].owner.login
        viewHolder.mWatchersCount.text = data[position].watchersCount.toString()
        viewHolder.mForkCount.text = data[position].forksCount.toString()
        viewHolder.mIssueCount.text = data[position].openIssuesCount.toString()
        viewHolder.mItem.setOnClickListener(OnItemClick(data[position], onClick))
        viewHolder.mThumbnail.setOnClickListener(OnThumbnailClick(data[position].owner, onClick))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class OnItemClick(repository: Repository, onClick: OnClick) : View.OnClickListener {
        var mRepository = repository
        var mOnItemClick: OnClick = onClick

        override fun onClick(view: View) {
            mOnItemClick.onRepositoryClick(mRepository)
        }
    }

    private class OnThumbnailClick(user: User, onClick: OnClick) : View.OnClickListener {
        var mUser = user
        var mOnThumbnailClick: OnClick = onClick

        override fun onClick(view: View) {
            mOnThumbnailClick.onThumbnailClick(mUser)
        }
    }
}