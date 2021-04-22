package com.cristian.pam1.data.repository

import com.cristian.pam1.data.api.ApiService
import com.cristian.pam1.ui.feed.models.FeedItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ContentRepository(private val service: ApiService) {

    suspend fun searchContent(category: String) : List<FeedItem> =
        service.searchContent(category).data
            .map {
                FeedItem(it.attributes.posterImage.small.toString(),
                    it.attributes.canonicalTitle,
                    it.attributes.description,
                    it.attributes.averageRating,
                    it.attributes.ageRatingGuide,
                    it.attributes.status
                )
            }

}