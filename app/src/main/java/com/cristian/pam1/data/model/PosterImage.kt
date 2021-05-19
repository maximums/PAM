package com.cristian.pam1.data.model

import com.google.gson.annotations.SerializedName
import java.net.URL

class PosterImage(
    val tiny: URL?,
    val small: URL?,
    val medium: URL?,
    val large: URL?,
    val original: URL?
) {

    data class MetaD(
        val dimensions: Dimensions
    )

    data class Dimensions(
        val tiny: Dim,
        val small: Dim,
        val medium: Dim,
        val large: Dim
    )

    data class Dim(
        @SerializedName("width")
        val width: String?,
        @SerializedName("height")
        val height: String?
    )
}