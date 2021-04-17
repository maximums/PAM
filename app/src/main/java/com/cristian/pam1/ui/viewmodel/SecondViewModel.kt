package com.cristian.pam1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cristian.pam1.data.model.APIResponse
import com.cristian.pam1.data.repository.ContentRepository
import com.cristian.pam1.ui.view.feed.models.FeedItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondViewModel(private val repository: ContentRepository) : ViewModel() {

    private val finalData = MutableLiveData<List<FeedItem>>()

    fun searchForContent(category: String){
        GlobalScope.launch {
            kotlin.runCatching {
                repository.searchContent(category)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                println("|||||||||||||||||||||||||||||||||||||||||||||||||\n$it")
            }
        }
    }

    private fun handleAPIData(data: APIResponse){
        val contentList = mutableListOf<FeedItem>()
        data.data.forEach { contentList.add(
            FeedItem(
                it.attributes.posterImage.tiny.toString(),
                it.attributes.canonicalTitle,
                it.attributes.description)
        ) }
        finalData.postValue(contentList)
    }

    fun getContent(): LiveData<List<FeedItem>> = finalData
}