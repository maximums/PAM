package com.cristian.pam1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristian.pam1.data.repository.ContentRepository
import com.cristian.pam1.ui.feed.models.FeedItem
import kotlinx.coroutines.launch

class ContentFragmentViewModel(private val repository: ContentRepository) : ViewModel() {

    private val finalData = MutableLiveData<List<FeedItem>>()

    fun searchForContent(category: String){
        viewModelScope.launch {
            kotlin.runCatching {
                repository.searchContent(category)
            }.onSuccess {
                finalData.postValue(it)
            }.onFailure {
                println("$it")
            }
        }
    }

    fun getContent(): LiveData<List<FeedItem>> = finalData
}