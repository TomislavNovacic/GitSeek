package com.tomislav.novacic.gitseek.ui.search

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


class SearchViewModel @Inject constructor(private val searchRepository: SearchRepository) : ViewModel() {
    val sortOption = MutableLiveData<String?>()
    val searchKeyword = MutableLiveData<String>()
    val response = Transformations.switchMap(DoubleTrigger(searchKeyword, sortOption)) {
        liveData(Dispatchers.IO) {
            val repositories = searchRepository.getRepositories(searchKeyword.value!!, sortOption.value)
            emitSource(repositories)
        }
    }
}

enum class SortOption(val value: String?) {
    BEST_MATCH(null),
    STARS("stars"),
    FORKS("forks"),
    UPDATED("last_updated")
}

class DoubleTrigger<A, B>(a: LiveData<A>, b: LiveData<B>) : MediatorLiveData<Pair<A?, B?>>() {
    init {
        addSource(a) { value = it to b.value }
        addSource(b) { value = a.value to it }
    }
}
