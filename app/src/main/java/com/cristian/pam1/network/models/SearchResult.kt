package com.cristian.pam1.network.models

import com.google.gson.annotations.SerializedName
import java.net.URL
import kotlin.collections.ArrayList


class SearchResult(val collection: Collection) {
    data class Collection(
        val href: URL,
        val items: Items,
        @SerializedName("version")
        val version : String,
        val links : Link?,
        val metadata : ResMetadata
    )

    data class ResMetadata(
        @SerializedName("total_hits")
        val total_hits: Int
    )

    data class Link(
        @SerializedName("prompt")
        val prompt: String,
        val href: URL,
        @SerializedName("rel")
        val rel: String
    )

    data class Items(
        val links: ArrayList<ItemLinks>,
        val href: URL,
        val data: ArrayList<InfoInutila>
    )

    data class ItemLinks(
        val href: URL,
        @SerializedName("render")
        val render: String,
        @SerializedName("rel")
        val rel: String
    )

    data class InfoInutila(
        @SerializedName("photographer")
        val photographer: String,
        @SerializedName("nasa_id")
        val nasa_id: String,
        @SerializedName("location")
        val location: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("date_created")
        val date_created: String,
        @SerializedName("center")
        val center: String,
        @SerializedName("album")
        val album: ArrayList<String>,
        @SerializedName("media_type")
        val media_type: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("keywords")
        val keywords: ArrayList<String>?
    )

}