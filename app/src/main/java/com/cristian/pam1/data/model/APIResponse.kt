package com.cristian.pam1.data.model

import com.google.gson.annotations.SerializedName
import java.net.URL

class APIResponse(
    val data: ArrayList<ContentObj>,
    val meta: Meta,
    val links: Links
) {
    data class Meta(
        @SerializedName("count")
        val count: String
    )
    data class Links(
        val first: URL?,
        val next: URL?,
        val last: URL?
    )
    data class ContentObj(
        @SerializedName("id")
        val id: String,
        @SerializedName("type")
        val type: String,
        val links: Link,
        val attributes: Attributes
    )
    data class Link(
        val self: URL?
    )
    data class Attributes(
        @SerializedName("canonicalTitle")
        val canonicalTitle: String?,
        @SerializedName("description")
        val description: String?,
        val posterImage: PosterImage
    )
}
