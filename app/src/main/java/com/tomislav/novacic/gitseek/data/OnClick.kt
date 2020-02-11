package com.tomislav.novacic.gitseek.data

import com.tomislav.novacic.gitseek.data.model.Repository
import com.tomislav.novacic.gitseek.data.model.User

interface OnClick {
    fun onRepositoryClick(repository: Repository)
    fun onThumbnailClick(user: User)
}