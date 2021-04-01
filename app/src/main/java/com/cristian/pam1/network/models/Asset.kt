package com.cristian.pam1.network.models

import com.google.gson.annotations.SerializedName
import java.net.URL

class Asset(val collection: Collection) {
    data class Collection(
        val href: URL,
        val item: ArrayList<Items>,
        @SerializedName("version")
        val version: String
    )

    data class Items(
        val href: URL
    )
}