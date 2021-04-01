package com.cristian.pam1.network

import com.cristian.pam1.network.models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface Service {

    @GET("search")
    suspend fun search(
        @Query("q") term : String,
        @QueryMap query: Map<String, String>?
    ) : ArrayList<SearchResult>

    @GET("asset/{nasa_id}")
    suspend fun getAssets(@Path("nasa_id") nasa_id : String) : ArrayList<Asset>

    @GET("metadata/{nasa_id}")
    suspend fun getMetadata(@Path("nasa_id") nasa_id : String) : ArrayList<MetaData>

    @GET("captions/{nasa_id}")
    suspend fun getCaptions(@Path("nasa_id") nasa_id : String) : ArrayList<Captions>

    @GET("album/album_name")
    suspend fun getAlbum(
        @Path("album_name") album_name : String,
        @Query("page") page: Int?
    ) : ArrayList<NasaAlbums>

}