package com.example.androiddata.data
import com.google.gson.annotations.SerializedName

import android.content.Context
import com.example.androiddata.IMAGE_BASE_URL

data class Film (
    @SerializedName("id") val id : String,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("director") val director : String,
    @SerializedName("producer") val producer : String,
    @SerializedName("release_date") val release_date : Int,
    @SerializedName("rt_score") val rt_score : Int,
    @SerializedName("people") val people : List<String>,
    @SerializedName("species") val species : List<String>,
    @SerializedName("locations") val locations : List<String>,
    @SerializedName("vehicles") val vehicles : List<String>,
    @SerializedName("url") val url : String
) {

//    fun getPosterName(): String? { //example: My Neighbor Totoro = my_neighbor_totoro_poster
//        return title.toLowerCase().replace(" ".toRegex(), "_").replace(
//            "'".toRegex(),
//            ""
//        ) + "_poster"
//    }
//    public fun getThumbnailName(): String? { //example: My Neighbor Totoro = my_neighbor_totoro
//        return title.toLowerCase().replace(" ".toRegex(), "_").replace("'".toRegex(), "")
//    }
//
//    public fun getPoster(context: Context): Int {
//        return context.resources
//            .getIdentifier(getPosterName(), "drawable", context.packageName)
//    }
//
//    fun getThumbnail(context: Context): Int {
//        return context.resources
//            .getIdentifier(getThumbnailName(), "drawable", context.packageName)
//    }
//    val imageUrl
//        get() = "$IMAGE_BASE_URL/$imageFile.webp"
    private fun getPosterName(): String? { //example: My Neighbor Totoro = my_neighbor_totoro_poster
    return title.toLowerCase().replace(" ", "_").replace("'", "")+"_poster";
    }

    public fun getPoster(context: Context): Int {
        return context.getResources().getIdentifier(getPosterName(), "drawable", context.getPackageName())
    }

    private fun getThumbnailName(): String? { //example: My Neighbor Totoro = my_neighbor_totoro
        return title.toLowerCase().replace(" ", "_").replace("'", "");
    }
    public fun getThumbnail(context: Context): Int {
        return context.getResources().getIdentifier(getThumbnailName(), "drawable", context.getPackageName())
    }
//    val image1 = context.resources.getIdentifier(tilte1, "drawable", context.getPackageName());


//    val thumbnailUrl
//        get() = "$IMAGE_BASE_URL/${imageFile}_tn.webp"
}
