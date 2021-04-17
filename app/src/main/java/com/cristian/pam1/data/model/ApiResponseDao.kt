package com.cristian.pam1.data.model

import androidx.lifecycle.MutableLiveData

class ApiResponseDao {
    private val contentList = mutableListOf<APIResponse>()
    private val content = MutableLiveData<List<APIResponse>>()

    init {
        content.value = contentList
    }

}