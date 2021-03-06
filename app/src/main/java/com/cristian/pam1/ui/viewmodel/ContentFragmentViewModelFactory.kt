package com.cristian.pam1.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cristian.pam1.data.repository.ContentRepository

class ContentFragmentViewModelFactory(private val repository: ContentRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContentFragmentViewModel(repository) as T
    }
}